package search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import DB.DBConnect;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet.do")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	    out.print("hello fangyu... this is my registerServlet.do post");
	
	    //connect the local JDBC and inter the new user into engine.user table
	    String firstName=request.getParameter("firstname");
		String lastName=request.getParameter("lastname");
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String mailAddr=request.getParameter("mailAddr");
		try{ 
			DBConnect connect=new DBConnect();
			  
			PreparedStatement ps=(PreparedStatement) connect.con.prepareStatement("insert into users(firstName,lastName,userName,password,email) values(?,?,?,?,?)");
			ps.setString(1,firstName);  
			ps.setString(2,lastName);  
			ps.setString(3,userName);  
			ps.setString(4,password);
            ps.setString(5,mailAddr); 
			          
			int i=ps.executeUpdate(); 
			if(i>0)  
			out.print("You are successfully registered...");  
			response.sendRedirect("userLogin.jsp");      			          
			}catch (Exception e2) {System.out.println(e2);}  
			          
			out.close();  
		}  
}
