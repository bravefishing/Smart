<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="background-color: #BC8832; color: Teal">  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>     
    <img src="image/head.png" style="width:800px;position:absolute;left:140px"/>
    <div class="container" style="width:800px;top:25%;position:absolute;left:140px">
        <div class="title" style="width:200px;position:absolute;left:5px;"><h3 style="color: White">login >> </h3></div>                 
        <br>
        <fieldset >
            <br>    
            <form action="loginServlet.do" method="post" style="text-align:center;color:white">
             <br>
             <div class="inputField">
                   <label for="username" class="inputlabel">User name: </label>
                   <input name="username" type="text">                 
             </div>
             <br>
             <div class="inputField">
                   <label for="password" class="inputlabel">Password:    </label>
                   <input name="password" type="password" style="width: 164px; ">                 
             </div> 
             <br>
            
             <div class="inputfield" id="submitfield">
                   <input id="submit" type="submit" value="Login" style="background-color: #CA9337;">
             </div> 
             </form></p>  
             
             </fieldset>       
            
       </div>
</body>
</html>