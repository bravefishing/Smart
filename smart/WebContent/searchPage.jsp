<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="background-color: #BC8832; color: Teal">  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DMSSS</title>
</head>
<body>     
  <img src="image/head.png" style="width:800px;position:absolute;left:140px"/>
  <title>Non-optional search results</title>
  <br><br><br><br><br><br><br><br>
  <fieldset style="width:800px;position:absolute;left:140px;">   


<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="process.associatedAttributesMap" %>
<%@ page import="process.InformationExtraction" %>
<%@ page import="process.traditionalSemanticProcess" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>
        <% 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dmsss","root","hao123");         
            Statement statement = connection.createStatement() ;
            String input=request.getParameter("search");
            InformationExtraction ie=new InformationExtraction(input);
            ie.extractAttributes();
            // the following codes is for firstUpdating the associatedweight
            associatedAttributesMap at=new associatedAttributesMap();
 		    at.firstUpdate(ie.extractAttributes());
            
            int num=ie.attributes.length;
            int j=0;
			String query="select * from disease where title like "+"'%"+ie.attributes[0].attributeName+"%'";
			while(num!=1){
				j++;
				query+=" or title like "+"'%"+ie.attributes[j].attributeName+"%'";
				num--;
			}
            ResultSet resultset = 
                    statement.executeQuery(query);
            %>
            <table>
                <% while(resultset.next()){ %>
                
                <% String idString=resultset.getString(1);
                   int id=Integer.parseInt(idString);
                   String description=resultset.getString(3);
              
                   String title=resultset.getString(2);
                   traditionalSemanticProcess sp=new traditionalSemanticProcess(ie,title);
 	               sp.weightSemanticProcess();
 	               double Relativity=sp.calculateRelativity();
 	              
 	            %>
 	             <%
 	             PreparedStatement pstatement=connection.prepareStatement("update disease set relativity=?where iddisease=?");
 	             pstatement.setDouble(1, Relativity);
 	             pstatement.setInt(2, id);
 	             int update=pstatement.executeUpdate();
 	            %>
             <% } %>
             <%
                    resultset.close();
         	        resultset.close();     	        
         	        resultset.close();
              %>
              
              
             <%
               int num2=ie.attributes.length;
               int j2=0;
               //String query2="select * from disease order by relativity DESC";
               String query2="select * from disease where title like "+"'%"+ie.attributes[0].attributeName+"%'";
			   while(num!=1){
				  j2++;
				  query2+=" or title like "+"'%"+ie.attributes[j].attributeName+"%'";
				  num2--;
			    }
			    query2+=" order by relativity DESC";			  
                resultset=statement.executeQuery(query2);
             %>        
            <table>
            <%int index2=1; %>
                <% while(resultset.next()){ %>
                
                <% String idString=resultset.getString(1);
                   int id=Integer.parseInt(idString);
                   String title=resultset.getString(2);
                   String description=resultset.getString(3);
                 %>
 	            <td> <%="the relativity is: "+resultset.getDouble(5) %> </td>
 	           
                <TR>
                    <td> <img src="<%=resultset.getString(4)%>" style="width:300px;height:300px"/></td>
                    <%---<td><%="No."+ resultset.getString(1) /*shows the id of image in the database*/ %></td> --%>
                    <td> <%="No."+index2+" ("+resultset.getString(1)+")"%> </td>
                    
                    <%!
                    public void executeTest(String title) throws IOException, SQLException {
                    	InformationExtraction ie2=new InformationExtraction(title);
                        
                        associatedAttributesMap at2=new associatedAttributesMap();
                        at2.secondUpdate(ie2.extractAttributes());
                    } 

                    %>
                    
                    <td> <a href="show.jsp?id2=<%=id%>&description=<%=description%>&title=<%=resultset.getString(2)%>" 
                            onclick="executeTest(title)"><%=resultset.getString(2)%></a> </td>
                </TR> 
                <% index2++;%> 
                <% } %>
                <%
                    resultset.close();
         	        resultset.close();     	        
         	        resultset.close();
                %>
            </table>
      </fieldset>
    </body>
 </html>