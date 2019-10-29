<%-- 
    Document   : userProfile
    Created on : 2019-4-16, 21:51:04
    Author     : zhouzhou
--%>

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

        
        <section id="profile" name="profile">
            
           
    <div class="container desc">
             <div class="col-lg-2 col-lg-offset-1">
              <h3>Profile</h3>
            </div>
            <br/>
        <hr>
        <form action="profile.htm">
            <!-- userName -->
            <div class="col-lg-12 ">
              <p>
               <label> userName:</label>  ${sessionScope.User.getUserName()}
              </p>
            </div>
          <!-- height -->
            <div class="col-lg-12 "> 
              <p>
                <label>  Height:  </label>  ${sessionScope.User.getHeight()}
              </p>
            </div>
              <!-- Weight -->
              <div class="col-lg-12 ">
                <p>
                        <label> Weight: </label>   ${sessionScope.User.getWeight()}
                </p>
              </div>
               <!-- Age -->
            <div class="col-lg-12 ">
              <p>
                <label>  Age:   </label>   ${sessionScope.User.getAge()}
              </p>
            </div>
                <!-- Gender -->
            <div class="col-lg-12 ">
              <p>
                <label>  Gender:   </label>  ${sessionScope.User.getGender()}
              </p>
            </div>
                

              <input type="submit" class="btn" value='Edit Profile'/>
           </form>  
          <hr>
        </div>
        <!--/.container -->
      </section>





        
    </body>
</html>
