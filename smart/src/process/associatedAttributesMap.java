package process;

import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import DB.DBConnect;

public class associatedAttributesMap{
	int index; 
	String attributeOne;
	String attributeTwo;
	int coocurrence;
	double associatedWeight;
	
	public associatedAttributesMap(){}
	
	public associatedAttributesMap(String newName1,String newName2){
		this.attributeOne=newName1;
		this.attributeTwo=newName2;
	}
	
	public boolean inTable() throws SQLException{
	    DBConnect connect=new DBConnect();
	    try{
	    	String q="select * from associatedattributes where attributeOne=? and attributeTwo=?";
	        PreparedStatement ps = null;
	        ps = (PreparedStatement) connect.con.prepareStatement(q);
		    ps.setString(1, attributeOne);
		    ps.setString(2, attributeTwo);
		    connect.rs = ps.executeQuery();
		    //determine whether the pair of associated attributes is exist or not		
		    if(connect.rs.next()){
		    	index=connect.rs.getInt(1);
			    coocurrence=connect.rs.getInt(4);
			    return true;
		    }
		    else{
		        return false;
		    }
	    }finally {
	    	try { 
	    		if (connect.rs != null) 
	    			connect.rs.close(); 
		   	} catch (Exception e) {};
	        try { 
	       	    if (connect.st != null) 
	    		    connect.st.close(); 
	       	} catch (Exception e) {};
		    
	       	try { 
	       		if (connect.con != null) 
	  		    connect.con.close(); 
		       	} catch (Exception e) {};
		}
	}
		
	public void insertAssociatedAttributes() throws SQLException{
		//insert new attribute
		DBConnect connect=new DBConnect();
		PreparedStatement ps=null;
		try{
		   ps=(PreparedStatement) connect.con.prepareStatement("insert into associatedattributes(attributeOne,attributeTwo,coocurrence) values(?,?,1)");
			//set the insert value for the attribute
		   coocurrence=1;
		   ps.setString(1,attributeOne);
		   ps.setString(2,attributeTwo);	
		   ps.executeUpdate();	 
		  // index=connect.rs.getInt(1);	   
		} catch(NullPointerException ex){
		   System.out.println("Exception handling code for the NullPointerException.");			
		}finally {
			try { 
		      	if (connect.rs != null) 
		       		connect.rs.close(); 
		       	} catch (Exception e) {};
	        try { 
	        	if (connect.st != null) 		        		
	        		connect.st.close(); 
		        	} catch (Exception e) {};
		    try { 
		       	if (connect.con != null) 
		       		connect.con.close(); 
		       	} catch (Exception e) {};
	   }
		//set each value for the attribute, //  if set value before executeUpdate, then the table result set is still empty, thus caused error
		
		System.out.println("You have successfully inserted the associated attributes "+attributeOne+" "+attributeTwo);
		//set each value for the attribute		
	}
	
	public void Update(int times) throws SQLException,NullPointerException{
		PreparedStatement ps=null;
		DBConnect connect=new DBConnect();
		//int coocurr=connect.rs.getInt("coocurrence");
		try{
			ps=(PreparedStatement) connect.con.prepareStatement("update associatedattributes set coocurrence=? where attributeOne=? and attributeTwo=?");
			ps.setInt(1,coocurrence+times);
		    ps.setString(2, attributeOne);
		    ps.setString(3, attributeTwo);
		    int i=ps.executeUpdate();
		    coocurrence=coocurrence+times;
		}finally {
			try { 
		       	if (connect.rs != null) 
		       		connect.rs.close(); 
		       	} catch (Exception e) {};
	        try { 
		       	if (connect.st != null) 
		       		connect.st.close(); 
		       	} catch (Exception e) {};
	        try { 
	        	if (connect.con != null) 		        		
	        		connect.con.close(); 
		       	} catch (Exception e) {};
	    }
		System.out.println("You have successfully updated the associatedAttributesMap "+attributeOne+" "+attributeTwo);		
	}
	
	public void firstUpdate(Attributes[] a) throws NullPointerException, SQLException{
		associatedAttributesMap[][] at=new associatedAttributesMap[a.length][a.length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
			    at[i][j]=new associatedAttributesMap(a[i].attributeName,a[j].attributeName);
				System.out.println(at[i][j].attributeOne+"  "+at[i][j].attributeTwo);
				if(at[i][j].inTable())
			    	at[i][j].Update(1);
		    	else
			    	at[i][j].insertAssociatedAttributes();
				System.out.println(at[i][j].coocurrence);		
			}
		}
		//calculate and update the associatedWeight in database
		PreparedStatement ps=null;
		DBConnect connect=new DBConnect();
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){			
			    at[i][j].associatedWeight=(double)(at[i][j].coocurrence)/(at[i][i].coocurrence+at[j][j].coocurrence-at[i][j].coocurrence);
				System.out.println(at[i][j].attributeOne+"  "+at[i][j].attributeTwo);
				System.out.println(at[i][j].associatedWeight*at[i][j].associatedWeight);
				
				ps=(PreparedStatement) connect.con.prepareStatement("update associatedattributes set associatedWweight=? where attributeOne=? and attributeTwo=?");
			    ps.setDouble(1,at[i][j].associatedWeight);
				ps.setString(2,at[i][j].attributeOne);
			    ps.setString(3,at[i][j].attributeTwo);
			    ps.executeUpdate();
			/*	}finally {
					try { 
				       	if (connect.rs != null) 
				       		connect.rs.close(); 
				       	} catch (Exception e) {};
			        try { 
				       	if (connect.st != null) 
				       		connect.st.close(); 
				       	} catch (Exception e) {};
			        try { 
			        	if (connect.con != null) 		        		
			        		connect.con.close(); 
				       	} catch (Exception e) {};
			    }*/
			}
		} 
	}
	
	public void secondUpdate(Attributes[] a) throws SQLException{
	    firstUpdate(a);
	}
	public void thirdUpdate() throws SQLException{
		Update(2);
	}

}
