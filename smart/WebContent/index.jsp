<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="background-color: #BC8832; color: Teal">  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DMSSS</title>
</head>
<body>     
       <img src="image/head.png" style="width:800px;position:absolute;left:140px"/>
       <div class="container" style="width:60px;position:absolute;left:940px;">   
         <form action="loginPage">
           <input type="submit" value="Login" style="background-color: #CA9337;">
         </form>
         <form action="registerPage">     
            <input type="submit" value="Register" style="background-color: #CA9337; width: 80px">
         </form>
       </div>
       <br><br><br><br><br><br><br><br> 
       
         <fieldset style="width:800px;height:300px;position:absolute;left:140px">    
            <form action="searchPage">   
                <input type="text" name="search" style="width: 290px;position:absolute;left:250px;top:40%">                
                <input type="submit" value="search" style="background-color: #CA9337;position:absolute;left:545px;top:40%">  
            </form>  
         </fieldset>
       
</body>
</html>