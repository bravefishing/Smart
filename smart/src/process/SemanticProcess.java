package process;

import java.io.IOException;

import DB.DBConnect;

public class SemanticProcess {
	Attributes[] searchAttribute;
	int searchAttributesNum;
	Attributes[] resultAttribute;
	int resultAttributesNum;
//	associatedAttributes[][] aAttibutes; here we use the database to store each pair of associated attributes
	float weight;
	float assocatedWeight;
	double relativity;
	
	public SemanticProcess(String input,String result) throws IOException{
		InformationExtraction ieSearch=new InformationExtraction(input);
		InformationExtraction ieResult=new InformationExtraction(result);
		searchAttribute=ieSearch.attributes;
		resultAttribute=ieResult.attributes;
		searchAttributesNum=ieSearch.attributes.length;
		resultAttributesNum=ieResult.attributes.length;	
		//????????????
	}
/*	
	//first weight
	public void firstWeight(){
		firstUpdate(searchAttribute);
	}
	//second weight
	public void secondWeight(){
		secondUpdate(resultAttribute);
	}
	//third weight
	public void thirdweight(){
		thirdUpdate(searchAttribute,resultAttribute);
	}
	//calculate the relativity for each snippets
	public void calculateRelativity(){
		for(int i=0;i<searchAttributesNum;i++)
		{
			for(int j=0;j<associatedAttributes;j++)
			{
				calculate(searchAttribute[i],searchAttribute[j]);
			}
		}
	}
	*/
}

