package process;

import java.io.IOException;

public class SyntaxExtraction extends OpenNLP {
	public SyntaxExtraction(String input) throws IOException {
		super(input);
		// TODO Auto-generated constructor stub
	}
	
	public Attributes[] extractAttributes(){
		int num=0;
		for(int i=0;i<attributeTag.length;i++){
			if(usefulTag(attributeTag[i])){
				num++;
			}
		}
		attributes=new Attributes[num];
		int j=0;
		for(int i=0;i<attributeTag.length;i++)
		{
			// filter useless tag
			if(usefulTag(attributeTag[i])){
				int size=attributeName[i].length();
				attributes[j]=new Attributes(attributeName[i],attributeTag[i]);
                j++;
			}	
		}
		return attributes;
	}
	
	public boolean usefulTag(String attributeTag){
		String[] usefulTag={"NN","NNS","NNP","NNPS"};
		boolean isUseful=false;
		
		for(int i=0;i<usefulTag.length;i++){
			if(usefulTag[i].equalsIgnoreCase(attributeTag)){
				return true;
			}
		}
		return isUseful;
	}
}
