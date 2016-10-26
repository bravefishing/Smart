package process;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class OpenNLP{
    
	public Attributes[] attributes;
	String[] attributeName;
	String[] attributeTag;
	public OpenNLP(String input) throws IOException{
		if(input!=null){	
		  POSModel model = new POSModelLoader().load(new File("en-pos-maxent.bin"));
	      PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
	      POSTaggerME tagger = new POSTaggerME(model);
	      ObjectStream<String> lineStream =
	        new PlainTextByLineStream(new StringReader(input));

	      perfMon.start();
	      String line;
	
	      while ((line = lineStream.read()) != null) {
	        attributeName = WhitespaceTokenizer.INSTANCE.tokenize(line);
	        attributeTag = tagger.tag(attributeName);
	        perfMon.incrementCounter();
	      }
	      perfMon.stopAndPrintFinalResult();
		}
	}
	public Attributes[] extractAttributes() throws NullPointerException{
		attributes=new Attributes[attributeName.length];
		for(int i=0;i<attributeName.length;i++)
		{
			int size=attributeName[i].length();
			if(attributeName[i].charAt(size-1)=='.'){
				attributeName[i]=attributeName[i].substring(0, size-1);
			}
			attributes[i]=new Attributes(attributeName[i],attributeTag[i]);
		}
		return attributes;	
	}
}

