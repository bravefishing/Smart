package process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

public class traditionalSemanticProcess {
	public String[] sentence;
	public String[] attributeName;
    double[] occurrence;
    double[] extractedWeight;//weight=occurrence/sentence.length
	
	public traditionalSemanticProcess(InformationExtraction ie,String result) throws InvalidFormatException, IOException{
		InputStream is = new FileInputStream("en-sent.bin");
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);
		sentence= sdetector.sentDetect(result);//sentences[0]
		ie.extractAttributes();
		System.out.println("the input has "+ie.attributes.length+" attributes.");
		attributeName=new String[ie.attributes.length];
		occurrence=new double[ie.attributes.length];
		extractedWeight=new double[ie.attributes.length];
		for(int i=0;i<ie.attributes.length;i++){
			attributeName[i]=ie.attributes[i].attributeName;
			occurrence[i]=0;
			extractedWeight[i]=0;
		}
		is.close();	
	}
	
	public double[] weightSemanticProcess() throws IOException{
		
		for(int i=0;i<extractedWeight.length;i++){
			for(int j=0;j<sentence.length;j++){
				if(isOccurrenced(attributeName[i],sentence[j])){
					occurrence[i]++;
				}
				else{
					System.out.println(attributeName[i]+"not in sentence"+j);
				}
			}
		}
		
		for(int i=0;i<extractedWeight.length;i++){
			extractedWeight[i]=occurrence[i]/(double)sentence.length;
		}
		return extractedWeight;
	}
	
	public double calculateRelativity(){
		double relativity=0;
		for(int i=0;i<attributeName.length;i++){
			relativity+=extractedWeight[i]*extractedWeight[i];
		}
		System.out.println(relativity);
		return relativity;
	}
	
	public boolean isOccurrenced(String attributeName,String seperateSentence) throws IOException,NullPointerException{
		attributeName=attributeName.toLowerCase();
		seperateSentence=seperateSentence.toLowerCase();
		int inSentence=seperateSentence.indexOf(attributeName);
	    if(inSentence!=-1){
	    	return true;
	    }
	    else
	    	return false;
	}
}
