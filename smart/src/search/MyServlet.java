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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import DB.DBConnect;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@SuppressWarnings("restriction")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	/*  used for tracking...
	 * 	String idN=request.getParameter("id");
		System.out.println(idN);  */
		
		String description=request.getParameter("description");
		System.out.println(description);
		
	    if(request.getParameter("id")!=null){
	    	response.setContentType("image/jpeg");
	        try{
	    	   InputStream is=getImageBlob(Integer.parseInt(request.getParameter("id")));
	    	   if(is!=null){
	    		  is=new BufferedInputStream(is);
	    		  BufferedImage bi=ImageIO.read(is);
	    		  OutputStream os=response.getOutputStream();
	    		  JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(os);
	    		  encoder.encode(bi);

	    		  os.close();
	    		  is.close();    	      
	    	   }
	       }catch(IOException e){
	    	   e.printStackTrace();
	       }catch(NumberFormatException e){
	    	   e.printStackTrace();
	       }catch(SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   } System.out.print("good read blod!!!");
	    }        
	    
	}
	
	public static InputStream getImageBlob(int id) throws SQLException{
		DBConnect connect=new DBConnect();
		String sql = "select image from disease where iddisease="+id;
		InputStream result=null;
		connect.rs=connect.st.executeQuery(sql);
		try{
		   if(connect.rs.next())
		   {
			  result=connect.rs.getBlob("image").getBinaryStream();
		   }
		}catch (SQLException e){
		   System.err.println(e.getMessage());
	   }finally{
		   connect.rs.close();
		   connect.st.close();
		   connect.con.close();
	   }
	   return result;
	}  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
