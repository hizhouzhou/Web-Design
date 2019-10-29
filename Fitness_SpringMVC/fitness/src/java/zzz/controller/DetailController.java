/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;
import zzz.dao.CourseDAO;
import zzz.dao.UserDAO;
import zzz.pojo.Coach;
import zzz.pojo.Course;
import zzz.pojo.User;


/**
 *
 * @author zhouzhou
 */
public class DetailController extends AbstractController{
    
     UserDAO userDAO;
    CourseDAO courseDAO;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
       String id =hsr.getParameter("courseID");
       String role=hsr.getParameter("role");
       
//       find the real courseid of this click --courseid
       long courseid =Long.valueOf(id);
       courseDAO=(CourseDAO)getApplicationContext().getBean("coursedao");
       Course course=courseDAO.getCourseDetail(courseid);
       hsr.setAttribute("course", course);

//      get the detail 
       if(role.equals("user")){
       mv = new ModelAndView("userCourseDetail","course",course);
       }else if(role.equals("coach")){
          mv = new ModelAndView("coachCourseDetail","course",course);  
       }  
       

       return mv;
    }
     
     
}
