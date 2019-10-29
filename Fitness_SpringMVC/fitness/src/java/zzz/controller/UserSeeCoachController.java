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
import zzz.dao.CoachDAO;
import zzz.pojo.Coach;
import zzz.pojo.Course;

/**
 *
 * @author zhouzhou
 */
public class UserSeeCoachController extends AbstractController{
    
    CoachDAO coachDAO;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
      
         ModelAndView mv = null;
         String id =hsr.getParameter("coachID");
         
         long coachID =Long.valueOf(id);
         coachDAO=(CoachDAO)getApplicationContext().getBean("coachdao");
         
         Coach coach=coachDAO.getCoach(coachID);
          List<Course> myCourse = coachDAO.getMyCourse(coachID);
          
            hsr.setAttribute("Coach",coach);
             hsr.setAttribute("myCourse", myCourse);
        mv= new ModelAndView("UserSeeCoach","myCourse",myCourse); 
        
        return mv;
    }
    
    
}
