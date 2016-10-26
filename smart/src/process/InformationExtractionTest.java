package process;

import java.io.IOException;

public class InformationExtractionTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String input="malaria is a very common and serious malady africa.";
		   InformationExtraction ie=new InformationExtraction(input);
		   ie.extractAttributes();
		   System.out.println(ie.attributes.length);
		   for(int i=0;i<ie.attributes.length;i++){
				System.out.println(ie.attributes[i].attributeName+"  "+ie.attributes[i].attributeTag);
			}
		   
		   String s="malady.";
		   System.out.println(s.length());
		   if(s.charAt(s.length()-1)=='.'){
			   s=s.substring(0, s.length()-1);
		   }
		   
		   System.out.println(s);
	}

}
