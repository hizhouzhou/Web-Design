/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.controller;

import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import zzz.dao.CoachDAO;
import zzz.pojo.Coach;
import zzz.pojo.Course;

/**
 *
 * @author zhouzhou
 */
public class CoachMyCourseController extends AbstractController{
    
    CoachDAO coachDAO;


    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       ModelAndView mv=null;
       System.out.println("hello");
       HttpSession session=hsr.getSession();
        coachDAO=(CoachDAO)getApplicationContext().getBean("coachdao");
      Coach coach=(Coach)session.getAttribute("Coach");
      System.out.println(coach);
      long coachid=coach.getCoachID();
      System.out.println(coachid);
      
//       String id=hsr.getParameter("coachID");
//       if(coachid!=null){
//        long coachID=Long.valueOf(id);
       List<Course> myCourse = coachDAO.getMyCourse(coachid);
        
           System.out.println(myCourse);
        hsr.setAttribute("myCourse", myCourse);
        mv=new ModelAndView("coachCourse","myCourse",myCourse);
//    
//       }else{
//           throw new Exception("id is null");
//       }

          return mv;  
    }


    
    
}
