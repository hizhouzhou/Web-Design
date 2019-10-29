/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;
import zzz.dao.CourseDAO;
import zzz.dao.UserDAO;
import zzz.pojo.Course;
import zzz.pojo.User;

/**
 *
 * @author zhouzhou
 */
public class SubscribeController extends AbstractController{
     UserDAO userDAO;
    CourseDAO courseDAO;
    long courseid;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       ModelAndView mv = null;
       String id =hsr.getParameter("courseID");
        System.out.println(id);
         if(id!=null && id.length()!=0){
          //从subscirbe进来
        courseid =Long.valueOf(id);
        courseDAO=(CourseDAO)getApplicationContext().getBean("coursedao");
       Course course=courseDAO.getCourseDetail(courseid);
             System.out.println("find the course by id:"+course);
       HttpSession session=hsr.getSession();
       User user=(User)session.getAttribute("User");

          
      userDAO=(UserDAO)getApplicationContext().getBean("userdao");
     //set不代表添加 到数据库了 ，需要在userDAO里再更新一次
       
        long userid=user.getUserID();
         userDAO=(UserDAO)getApplicationContext().getBean("userdao");
       userDAO.updateSubscribe(user,course);
         
      
             //subscirbe 成功
              List<Course> myCourse = userDAO.getMyCourse(userid);
//             System.out.println("users's course:"+ myCourse);
       
       hsr.setAttribute("myCourse", myCourse);
        mv= new ModelAndView("userCourse","myCourse",myCourse); 
  
         }else{
             
             //从导航栏进来  看user my course
              HttpSession session=hsr.getSession();
              User user=(User)session.getAttribute("User");
              long userid=user.getUserID();
              userDAO=(UserDAO)getApplicationContext().getBean("userdao");
              
       List<Course> myCourse = userDAO.getMyCourse(userid);
             System.out.println("user course is "+ myCourse);
           hsr.setAttribute("myCourse", myCourse);
        mv= new ModelAndView("userCourse","myCourse",myCourse);
         } 
      
     
      
       return mv;
    }
    
    
}
