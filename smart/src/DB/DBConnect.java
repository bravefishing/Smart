/**
 * 
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * @author fish
 *
 */
public class DBConnect {
	public Connection con=null;
	public Statement st=null;
	public ResultSet rs=null;
    
	public DBConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dmsss","root","hao123");//second parameter is username ,third is password which here is empty
			st=con.createStatement();
			System.out.println("good connect");
					
		}catch(Exception e){
			System.err.println(e);
		}
	}
}
