<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show more details about disease map</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="DB.DBConnect" %>
<%@ page import="process.InformationExtraction" %>
<%@ page import="process.associatedAttributesMap" %>

<%
    String title=request.getParameter("title");
    InformationExtraction ie2=new InformationExtraction(title);
    associatedAttributesMap at2=new associatedAttributesMap();
    at2.secondUpdate(ie2.extractAttributes());

    String ID=request.getParameter("id2");
    int id=Integer.parseInt(ID);
    DBConnect connect=new DBConnect();
	String sql = "select * from disease where iddisease="+id;
	connect.rs=connect.st.executeQuery(sql);
	try{
	   if(connect.rs.next()) { %>
	       <td> <img src="<%=connect.rs.getString(4)%>"/></td>
           <td> <%="No."+ connect.rs.getString(3) %></td>
                     
<% 	   }
   }catch (SQLException e){
	   System.err.println(e.getMessage());
   }finally{
	   connect.rs.close();
	   connect.st.close();
	   connect.con.close();
   }

%>

<div>
<fieldset style="background:orange;width:800px;height:20px;position:absolute;left:140px;top:90%">
<form action="thirdUpdate">
  Are you satisfied with the result?
  <input type="submit" value="yes" style="background-color: #CA9337;position:absolute;left:750px;top:85%">
</form>
</fieldset>
</div>

</body>
</html>