/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import zzz.dao.CourseDAO;
import zzz.dao.UserDAO;
import zzz.pojo.Course;
import zzz.pojo.User;

/**
 *
 * @author zhouzhou
 */
public class CancelController extends AbstractController {

    UserDAO userDAO;
    CourseDAO courseDAO;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
           ModelAndView mv = null;
           String id =hsr.getParameter("courseID");
           
           long courseid =Long.valueOf(id);
        courseDAO=(CourseDAO)getApplicationContext().getBean("coursedao");
       Course course=courseDAO.getCourseDetail(courseid);
       
       HttpSession session=hsr.getSession();
       User user=(User)session.getAttribute("User");
       
       userDAO=(UserDAO)getApplicationContext().getBean("userdao");
       
        long userid=user.getUserID();
         userDAO=(UserDAO)getApplicationContext().getBean("userdao");
          userDAO.cancelSubscribe(user,course);
          
           List<Course> myCourse = userDAO.getMyCourse(userid);
       
       hsr.setAttribute("myCourse", myCourse);
        mv= new ModelAndView("userCourse","myCourse",myCourse); 
        
        return mv;
    }

    
}
