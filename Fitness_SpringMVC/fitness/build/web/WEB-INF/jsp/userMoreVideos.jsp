<%-- 
    Document   : userMoreVideos
    Created on : 2019-4-21, 23:36:32
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

         <!--show all information-->
      <div class="container">
          
              <h1>All courses:</h1>
       <form class="form-inline my-2 my-lg-0" action="search.htm" >
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
              <br/>
        <a href="search.htm?level=easy" class=" btn-sm btn-danger">Easy Level</a>
         <a href="search.htm?level=medium" class=" btn-sm btn-secondary">Medium Level</a>
          <a href="search.htm?level=hard" class=" btn-sm btn-warning">Hard Level</a>

        <hr/>
              <div class="row align-items-start" >
                  <c:forEach var="result" items="${requestScope.allCourse}" >
                      <div class="card col-sm-offset-1" style="width:20rem;height:25rem">
                          
                   
                          <div class="card-body">
                               <img class="card-img-top" src="${result.getCoverurl()}" alt="Card image" style="width:100%; height:50%; left:0px;top:125px;" 
                              </div>
                    
                                <div class="card-body"  >
                                    <h5 class="card-text"><b>Name:</b> <c:out value="${result.getName()}" /></h5>
                                  <h5 class="card-text"><b>Level:</b> <c:out value="${result.getLevel()}" /></h5>
                                  <h5 class="card-text"><b>Description:</b> <c:out value="${result.getDescription()}" /></h5>
                                  <a href="detail.htm?courseID=${result.getCourseID()}&role=user" class="card-link">Watch Detail</a>
                      </div>
                  </div>
                
                  </div>         
                  </c:forEach>

</div>
      </div>  

        
    </body>
</html>
