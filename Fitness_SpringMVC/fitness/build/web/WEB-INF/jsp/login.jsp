<%-- 
    Document   : login
    Created on : 2019-4-12, 16:25:59
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
           <h1>Login</h1>
        <form:form commandName="login"  method="post" action="login.htm">
            <!--username-->
            <div class="textbox">
                 <i class="fas fa-user"></i>
<!--            <label>username:</label>    -->
            <form:input path="userName" type="text" placeholder="Username"/>
            <form:errors path="userName"/>
            </div>
            <!--password-->
            <div class="textbox">
             <i class="fas fa-lock"></i>
<!--            <label>password:</label>        -->
            <form:input path="password" type="password" placeholder="Password"/> 
            <form:errors path="password"/>
            </div>
            <input type="submit"  value="Login" class="btn"/>
        </form:form>
          <br/>
            <div><a href="register.htm">Click to Register</a></div>
       </div> 
        </body>
</html>

