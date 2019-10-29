<%-- 
    Document   : register
    Created on : 2019-4-12, 14:45:17
    Author     : zhouzhou
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <link rel="stylesheet" href="./css/login.css" type="text/css">
      
    </head>
    <body>
        <div class="login-box">
           <h1>Register</h1>
        <form:form commandName="register"  method="post" action="register.htm">
             <div class="textbox">
                 <i class="fas fa-user"></i>
           <form:input path="userName" type="text" placeholder="New username"/> 
           <form:errors path="userName" />
             </div>
              <div class="textbox">
             <i class="fas fa-lock"></i>
             <form:input path="password" type="password" placeholder="New password"/> 
             <form:errors path="password" />
              </div>
            <br/>
           
            <label> Role: </label> 
             <label>User</label> <form:radiobutton path="personType" value="User" name="personType" />
              <label>Coach</label>  <form:radiobutton path="personType" value="Coach"  name="personType" />
              <br/>
              <span class="role"><form:errors path="personType" /></span>

             <input type="submit"  value="Register" class="btn"/>
        </form:form>
             <div><a href="login.htm">Click to Login</a></div>
             <h3>${sessionScope.message}</h3>
            </div>
            
    </body>
</html>
