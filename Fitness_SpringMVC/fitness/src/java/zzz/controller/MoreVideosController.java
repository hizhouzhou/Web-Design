/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import zzz.dao.UserDAO;
import zzz.pojo.Course;

/**
 *
 * @author zhouzhou
 */
public class MoreVideosController extends AbstractController{

    UserDAO userDAO;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       
          ModelAndView mv=null;
          userDAO =(UserDAO)getApplicationContext().getBean("userdao");
          
           List<Course> allCourse = userDAO.getAllCourse();
           
           String role = hsr.getParameter("role");
            hsr.setAttribute("allCourse", allCourse);
           if(role.equals("user")){
                mv=new ModelAndView("userMoreVideos","allCourse",allCourse);
           }else if(role.equals("coach")){
                mv=new ModelAndView("coachMoreVideos","allCourse",allCourse);
           }
          return mv;
    }
  
    
    
}
