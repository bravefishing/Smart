package process;

import java.sql.SQLException;

import DB.DBConnect;

public class Rank {
	int id;
	String title;
	String description;
	String imageURL;

	public Rank() {
		// TODO Auto-generated constructor stub
	}
	
	public void display () throws SQLException{
		DBConnect conn =new DBConnect();
		String sql = "SELECT iddisease, title, description FROM disease" +
                " ORDER BY relativity DECS";
        conn.rs = conn.st.executeQuery(sql);
        
        while(conn.rs.next()){
        	id  = conn.rs.getInt("iddisease");
            title = conn.rs.getString("title");
            description = conn.rs.getString("description");
            imageURL=conn.rs.getString("image");
        }
        conn.rs.close();
	}
}
