package process;

import java.io.IOException;
import java.sql.SQLException;

public class associatedAttributesTest {
// those following code will be used in jsp file to set the values to associated attributes in this map
	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub	
		   String input2="apple pie";
		   InformationExtraction ie=new InformationExtraction(input2);
		   ie.extractAttributes();
		   associatedAttributesMap at=new associatedAttributesMap();
		   at.secondUpdate(ie.extractAttributes());
	}
}
