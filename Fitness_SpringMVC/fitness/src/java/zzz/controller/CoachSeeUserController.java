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
import zzz.pojo.User;

/**
 *
 * @author zhouzhou
 */
public class CoachSeeUserController extends AbstractController{
    
     UserDAO userDAO;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
         ModelAndView mv = null;
       String id =hsr.getParameter("userID");
       
       long userID =Long.valueOf(id);
     
           userDAO=(UserDAO)getApplicationContext().getBean("userdao");
         User user = userDAO.getUser(userID);
           List<Course> myCourse = userDAO.getMyCourse(userID);
           
             hsr.setAttribute("User",user);
             hsr.setAttribute("myCourse", myCourse);
        mv= new ModelAndView("CoachSeeUser","myCourse",myCourse); 
        
        return mv;
    }
     
     
}
