package search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBConnect;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet.do")
public class loginServlet extends HttpServlet { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     *
     */
    public loginServlet() {
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
	    out.print("hello fangyu... this is loginServlet.do post");
		DBConnect connect=new DBConnect();
	    //stop here    
		
		String username=request.getParameter("username");
		String pw=request.getParameter("password");
		try {
			connect.rs = connect.st.executeQuery("select password from users where userName='" + username + "'");
			if (connect.rs.next()) {  
	            // the username exist  
	            String passwd = connect.rs.getString(1);  
	            if (passwd.equals(pw)) {  
	                // valid 
	                // stored the user info into session  
	                HttpSession hs = request.getSession(true);
	              //  hs.setMaxInactiveInterval(30);  
	                hs.setAttribute("name", username);  
	                response.sendRedirect("logged.jsp");// Ìø×ª  
	            } else {
		            response.sendRedirect("fail.jsp");
	            }  
	        } else {  
	            //username is not exist
	    	    out.print("This user is not exist, please login again!");
	            response.sendRedirect("fail.jsp");  
	        }  
					
			
		}catch (Exception ex) {  
	        ex.printStackTrace();
		}finally {// close by the diverse of opening order
			try{
				if (connect.rs != null) {  
					connect.rs.close();  
	            }  
	            if (connect.st != null) {  
	            	connect.st.close();  
	            }  
	            if (connect.con != null) {  
	            	connect.con.close();  
	            }  
			}catch (Exception ex) {  
	            ex.printStackTrace();  
	        }  			
		}	
	}	 		
}

