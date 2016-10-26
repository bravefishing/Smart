package process;

import java.io.IOException;

public class test {
	public static void main(String[] args) throws IOException,NullPointerException {
		// TODO Auto-generated method stub
		String input="malaria is a very common and serious malady.";
      //  ParseSearchQuery pSearch=new ParseSearchQuery(input);
		OpenNLP nlp=new OpenNLP(input);
		nlp.extractAttributes();
		for(int i=0;i<nlp.attributeName.length;i++){
	//	    System.out.println(nlp.attributeName[i]+"  "+nlp.attributeName.length);
	//	    System.out.println(nlp.extractAttributes()[i].attributeName+" "+nlp.extractAttributes()[i].attributeTag);
		    System.out.println(nlp.attributes[i].attributeName+" "+nlp.attributes[i].attributeTag);
		}
		int i=nlp.attributes[nlp.attributes.length-1].attributeName.length();
		System.out.println(nlp.attributes[nlp.attributes.length-1].attributeName.charAt(i-1));
		
		
		String Str = new String("malaria is a very common and serious africa malady .");
		Str=Str.toLowerCase();
		String st2="african".toLowerCase();
	    System.out.print("Found Index :" );
	    System.out.println("include in: "+Str.indexOf(st2));
	}
}
