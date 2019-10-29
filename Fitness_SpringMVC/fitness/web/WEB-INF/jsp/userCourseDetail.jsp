<%-- 
    Document   : userCourseDetail
    Created on : 2019-4-22, 0:53:14
    Author     : zhouzhou
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
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

        
        <!--show the details-->
        <div class ="container">
<div class="show-header">
    <div class="container -flush">
      <div class="media">
        <div class="responsive-video">
          <iframe width="700" height="394" src="${requestScope.course.getUrl()}"  frameborder="0" allowfullscreen="1"></iframe>
        </div>
      </div>
     

      <div class="info has-actions">
    
          <div class="video-details">
            <h2 class="heading caps-half demi ">Workout Details</h2>
           
              <ul class="details-list">
                  
                <li>
                  <span class="detail-header">Name:</span>
                  <span class="detail-value demi">${requestScope.course.getName()} </span>
                </li>
                <li>
                  <span class="detail-header">Description:</span>
                  <span class="detail-value demi">${requestScope.course.getDescription()} </span>
                </li>
                <li>
                  <span class="detail-header"><i class="fas fa-award"></i> Difficulty:  </span>
                  <span class="detail-value demi">${requestScope.course.getLevel()} </span>
                </li>
               
                  <!-- subscribe -->
    
              </ul>
            <a href="subscribe.htm?courseID=${requestScope.course.getCourseID()}" class=" btn-sm btn-warning" >Subscirbe this course!</a>
            
            <h2 class="heading caps-half demi "> Want to see this creater's Main page?</h2>
             <a href="userseecoach.htm?coachID=${requestScope.course.getCoachID()}" class=" btn-sm btn-danger" ><i class="fas fa-arrow-right"></i></a>
       </div></div></div></div>
        
 
        
    
    </body>
</html>
