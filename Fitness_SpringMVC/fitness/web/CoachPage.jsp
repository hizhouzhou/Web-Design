<%-- 
    Document   : CoachPage
    Created on : 2019-4-12, 19:11:03
    Author     : zhouzhou
--%>

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
        <a class="nav-link" href="CoachPage.jsp" ><i class="fas fa-home"></i> Home<span class="sr-only">(current)</span></a>
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
      
           <div>
            <img src="./css/images/coachcoacmain.jpg" alt="main picture"/>
        </div>
        
        <div class="joinus" >Find Your Fitness.<br/>
                    Something for Everyone.
                <br/>
                 <a href="moreVideos.htm?role=coach">
                    <span class="menu-icon"><i class="icon -fitness" aria-hidden="true"></i></span>
                    <span class="menu-label">  <i class="fab fa-youtube"></i> More Videos</span></a></div>
       
 
    </body>
</html>
