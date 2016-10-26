package process;

import java.io.IOException;

public class extractedAttributesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String input="malaria is a very common and serious malady";
		InformationExtraction ie=new InformationExtraction(input);
	    ie.extractAttributes();
	    int num=ie.attributes.length;
	    double weight[]=new double[num];
	    for(int i=0;i<num;i++){
			ie.attributes[i].setWeight(/*weight[i]*/i/2);
		}
	    for(int i=0;i<num;i++){
			System.out.println(ie.attributes[i].getWeight());
		}
	    
	}

}
