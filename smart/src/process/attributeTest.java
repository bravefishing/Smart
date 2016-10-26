package process;

import java.sql.SQLException;

public class attributeTest {

	public static void main(String[] args) throws SQLException,NullPointerException {
		// TODO Auto-generated method stub
		double sentenceNum=8;
		double occurrence=3;
		double w=occurrence/sentenceNum;
		
		String input[]={"malaria","africa"};
	/*	for(int num=0;num<input.length;num++){	
	    	Attributes a=new Attributes();
	    	a.setAttributeName(input[num]);
	    	a.setWeight(w);
	    	if(a.inTable())
		    	a.updateAttribute();
	    	else
		    	a.insertAttribute();	
		    System.out.println(a.getAttributeName()+" "+a.getWeight()+"  ");
	    }*/
	}
}
