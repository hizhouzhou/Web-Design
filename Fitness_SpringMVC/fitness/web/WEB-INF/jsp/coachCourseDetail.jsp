<%-- 
    Document   : coachCourseDetail
    Created on : 2019-4-22, 2:27:38
    Author     : zhouzhou
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Coach</title>
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

      <!-- current page:coach's main page -->
      <li class="nav-item active">
        <a class="nav-link" href="CoachPage.jsp" ><i class="fas fa-home"></i> Home</a>
      </li>

      <!-- profile page -->
      <li class="nav-item">
        <a class="nav-link" href="coachProfile.jsp"><i class="far fa-id-card"></i> Profile</a>
      </li>


     <!-- update my new video -->
    <li class="nav-item">
  <a class="nav-link" href="mycourse.htm" > <i class="fab fa-discourse"></i> My courses</a>
     </li>

        <!-- update my new video -->
        <li class="nav-item">
            <a class="nav-link"  href="course.htm" > <i class="fas fa-cloud-upload-alt"></i> Upload course video</a>

          </li>

           <!-- view all videos -->
        <li class="nav-item">
            <a class="nav-link" href="moreVideos.htm?role=coach" > <i class="fab fa-youtube"></i> More videos</a>
          </li>
     
    </ul>

    <form class="form-inline my-2 my-lg-0" action='login.htm'>
        Hello Coach ${sessionScope.Coach.getUserName()} &nbsp;
        <button class="btn btn-outline-success my-2 my-sm-0" ><i class="fas fa-sign-out-alt" ></i>Logout</button>
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

              </ul>
            
          </div></div></div></div>
                <hr>
                <div>
 <div class="feed">
  <h2 class="heading -x-small caps-half demi details">Video Feed</h2>
</div> 
                
                <h3>  The users who likes this video:</h3>

                <div class="list-group">
                      <c:forEach var="result" items="${requestScope.course.getUsers()}" >
                          <a href="coachseeuser.htm?userID=${result.getUserID()}"  class="list-group-item list-group-item-action" >
                              ${result.getUserName()}
                          </a>
                 </c:forEach>
              </div>
       
         
</div>
        </div>
        
       
    </body>
</html>
