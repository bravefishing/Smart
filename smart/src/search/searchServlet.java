package search;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBConnect;
import com.mysql.jdbc.Blob;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet.do")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("restriction")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
	    System.out.print("hello fangyu... this is searchServlet.do post...hahahahahah");
	    DBConnect connect=new DBConnect();
	    String text=request.getParameter("search");
	   // text="%"+text+"%";
    	String q="SELECT idmalaria, title FROM malaria" +
    			" WHERE title LIKE '%malaria%'";
	      
    		    try {
						connect.rs = connect.st.executeQuery(q);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
   
			     try {
					while (connect.rs.next()) {
							int idmalaria  = connect.rs.getInt(1);
							String id=request.getParameter("id");
							int ID=Integer.parseInt(id);
					         String title = connect.rs.getString(2);
			
					         //PrintWriter out=response.getWriter();
					         System.out.print("Number: " + idmalaria);	
					         System.out.print(", title: " + title);				               
					         response.setContentType("image/jpeg");
					         
						        try{
						    	   InputStream is=getImageBlob(ID);
						    	     if(is!=null){
						    		  is=new BufferedInputStream(is);
						    		  BufferedImage bi=ImageIO.read(is);
						    		  OutputStream os=response.getOutputStream();
						    		  @SuppressWarnings("restriction")
									JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(os);
						    		  encoder.encode(bi);
						    		  os.flush();
						    		  os.close();	
						    	   }
						    	      
						    	     is.close();
						       }catch(IOException e){
						    	   e.printStackTrace();
						       }catch(NumberFormatException e){
						    	   e.printStackTrace();
						       }catch(SQLException e) {
								// TODO Auto-generated catch block
								   e.printStackTrace();
							   } System.out.print("good read blod!!!");  
					         
					}
				} catch (ImageFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
			  
			      try {
						connect.rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   try {
						connect.st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   try {
						connect.con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   				      
}
    		     
     
	
	public static InputStream getImageBlob(int id) throws SQLException{
		DBConnect connect=new DBConnect();
		String sql = "select image from malaria where idmalaria="+id;
		InputStream result=null;
		connect.rs=connect.st.executeQuery(sql);
		try{
		   if(connect.rs.next())
		   {
			  result=connect.rs.getBlob("image").getBinaryStream();
		   }
		}catch (SQLException e){
		   System.err.println(e.getMessage());
	   }
	   return result;
	}  

}
