<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="background-color: #BC8832; color: Teal">  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>logged in</title>
</head>
<body>     
    <img src="image/head.png" style="width:800px;position:absolute;left:140px"/>
    <div class="container" style="width:800px;top:25%;position:absolute;left:140px">
       <div class="title">Hi,DMSSS! </div>
       <form action="option">
       <fieldset>
            <br>
            <select name="options" style="color:brown">
               <option value="General">General</option>
               <option value="Private">Private</option>
               <option value="Noun">Noun</option>
            </select>  
            <br/>
            <br>
            <div style="top:40%;text-align: center;height:200px">
            
            <div class="inputField">   
               <input type="text" name="search">                
               <input type="submit" value="Search" style="background-color: #CA9337;">
            </div>
         </div>
       </fieldset> 
       </form>  
    </div> 
</body>
</html>