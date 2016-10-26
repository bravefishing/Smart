<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html style="background-color: #BC8832; color: Teal">  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>     
    <img src="image/head.png" style="width:800px;position:absolute;left:140px"/>
    <div class="container" style="width:800px;top:25%;position:absolute;left:140px">
        <div class="title" style="width:200px;position:absolute;left:5px;"><h3 style="color: White">register >> </h3></div>                 
        <br>
        <fieldset >
            <br>
            <form action="registerServlet.do" method="post" style="text-align:center;color:white">          
                <div class="inputField">
                   <label for="firstname"class="inputlabel">First name: </label>
                   <input name="firstname"type="text"></input>                 
                </div> 
             <br></br>
             <div class="inputField">
                   <label for="lastname"class="inputlabel">Last name: </label>
                   <input name="lastname"type="text"></input>
             </div> 
             <br></br>
             <div class="inputField">
                   <label for="username"class="inputlabel"> Username:  </label>
                   <input name="username"type="text"></input>                 
             </div> 
             <br></br>
             <div class="inputField">
                   <label for="password"class="inputlabel">Password:  </label>
                   <input name="password"type="text"></input>                 
             </div> 
             <br></br>
            
             <div class="inputField">
                   <label for="mailAddr"class="inputlabel">Email:     </label>
                   <input name="mailAddr"type="text"></input>                 
             </div>
              
             <br></br>
             <div class="inputfield" id="submitfield">
                   <input id="submit" type="submit" value="register" style="background-color: #CA9337;"></input>
             </div>
             
          </form>
       </fieldset>           
    </div>
</body>
</html>