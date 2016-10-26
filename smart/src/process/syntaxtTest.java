package process;

import java.io.IOException;

public class syntaxtTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	   String input="malaria is a very common and serious malady africa .";
	   SyntaxExtraction se=new SyntaxExtraction(input);
	   se.extractAttributes();
	   System.out.println(se.attributes.length);
	   for(int i=0;i<se.attributes.length;i++){
			System.out.println(se.attributes[i].attributeName+"  "+se.attributes[i].attributeTag);
		}
	}
}
