<%-- 
    Document   : editProfile
    Created on : 2019-4-18, 2:29:39
    Author     : zhouzhou
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css">
         <link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" 
               integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/form.css" type="text/css">
    </head>
    <body>
        <!--nav bar-->
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">Casual Fitness</a>
    
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">


        <li class="nav-item active">
          <a class="nav-link" href="UserPage.jsp"><i class="fas fa-home"></i>Home<span class="sr-only">(current)</span></a>
        </li>
        
          <li class="nav-item">
            <a class="nav-link" href="userProfile.jsp"><i class="far fa-id-card"></i>Profile</a>
        </li>


        <li class="nav-item">
              <a class="nav-link" href="usermycourse.htm"> <i class="fab fa-discourse"></i>My Courses</a>
        </li>


        <li class="nav-item">
          <a class="nav-link" href="moreVideos.htm?role=user"><i class="fab fa-youtube"></i>More Videos</a>
        </li>
      </ul>
        <form class="form-inline my-2 my-lg-0" action='login.htm'>Hello User ${sessionScope.User.getUserName()} &nbsp;
        <button class="btn btn-outline-success my-2 my-sm-0"><i class="fas fa-sign-out-alt" ></i>Logout</button>
    </form>
        </div>
  </nav>
        <!--nav bar end-->

     
        
        <!--form to save user's information-->
        <!--form to save coach's information-->
              <section id="profile" name="profile">
             
    <!-- title -->
    <div class="page-header">
            <h3 class="text-center">
                    Profile Form
                </h3>
    </div>

    <div class='container'>
    <!-- row -->
    <form:form commandName="userprofile"  method="post" action="profile.htm">
        
        <div class="form-row">
             <!--userID->
-->            <div class="form-group">
                 <label for="userID" class="col-lg-6 control-label">User ID: </label>
                  <form:input class="form-control col-lg-6" path="userID" type="text" value=" ${sessionScope.User.getUserID()}" readonly="true"/>
            </div>
       
             <!--userName-->
            <div class="form-group">
                 <label for="userName" class="col-lg-6 control-label">User Name: </label>
                  <form:input class="form-control col-lg-6" path="userName" type="text" value=" ${sessionScope.User.getUserName()}" readonly="true"/>
            </div>
        </div>
            
            <hr><br/>
            
           <div class="form-row">
             <!--Height-->
            <div class="form-group">
               <label  class="col-lg-6 control-label">Your Height(cm): </label>
                  <form:input class="form-control col-lg-6" path="height" type="text" value=" ${sessionScope.User.getHeight()}" pattern="$*[0-9]+([.]{1}[0-9]+){0,1}$|^$" />
            </div>
            </div> 
            
             <div class="form-row">
             <!--Weight-->
            <div class="form-group">
                 <label  class="col-lg-6 control-label">Your Weight(kg): </label>
                  <form:input class="form-control col-lg-6" path="weight" type="text" value="${sessionScope.User.getWeight()}" pattern="$*[0-9]+([.]{1}[0-9]+){0,1}$|^$"/>
            </div>
             </div>
            
             <div class="form-row">
             <!--Age-->
            <div class="form-group">
                 <label for=" Age" class="col-lg-6 control-label">Age: </label>
                  <form:input class="col-lg-6 form-control" path="age" type="text" value="${sessionScope.User.getAge()}" pattern="[0-9]+" />
            </div>
            
             </div>
            
             <div class="form-row">
             <!--Gender-->
            <div class="form-group">
                 <label for=" Gender" class="col-lg-15 control-label">Gender: (${sessionScope.User.getGender()} now)</label> 
              <br/>
                 <label class="col-lg-7 control-label"> Male:</label>
                 <form:radiobutton class="form-control" path="gender" value="Male"  readonly="true" name="gender" />
             
             
                   <label class="col-lg-7 control-label"> Female:</label> 
                   <form:radiobutton class=" form-control" path="gender" value="Female"  readonly="true" name="gender" /> 
       
                    
            </div>
             </div>
       
            <input type='submit' value='Save Profile' class='btn'/>
    </form:form>
    </div>  </section>
       
    </body>
</html>
