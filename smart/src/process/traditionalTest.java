package process;

import java.io.IOException;
import java.sql.SQLException;

import opennlp.tools.util.InvalidFormatException;

public class traditionalTest {

	public static void main(String[] args) throws NullPointerException, IOException {
		// TODO Auto-generated method stub
		InformationExtraction ie2=new InformationExtraction("malaria is a very common and serious africa malady");
		ie2.extractAttributes();
	    traditionalSemanticProcess sp=new traditionalSemanticProcess(ie2,"malaria is malady. Malaria is a very common and serious africa malady.");
		sp.weightSemanticProcess();
		
		    for(int i=0;i<sp.attributeName.length;i++){
		    	System.out.println(sp.attributeName[i]);
		    }
		    for(int i=0;i<sp.attributeName.length;i++){
		    	System.out.println(sp.occurrence[i]);
		    }
		    for(int i=0;i<sp.attributeName.length;i++){
		    	System.out.println(sp.extractedWeight[i]);
		    }
		    
		    System.out.println(sp.calculateRelativity());
	}
		
}
