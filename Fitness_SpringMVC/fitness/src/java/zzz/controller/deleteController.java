/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.controller;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import zzz.dao.CoachDAO;
import zzz.dao.CourseDAO;
import zzz.pojo.Coach;
import zzz.pojo.Course;

/**
 *
 * @author zhouzhou
 */
public class deleteController extends AbstractController{
    
      CoachDAO coachDAO;
        CourseDAO courseDAO;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
         ModelAndView mv=null;
         
//         get coach id
          HttpSession session=hsr.getSession();
          coachDAO=(CoachDAO)getApplicationContext().getBean("coachdao");
          Coach coach=(Coach)session.getAttribute("Coach");
          long coachid=coach.getCoachID();
          
          
          //delete the course
            
            String id =hsr.getParameter("courseID");
             long courseid =Long.valueOf(id);
              courseDAO=(CourseDAO)getApplicationContext().getBean("coursedao");
               Course course=courseDAO.getCourseDetail(courseid);
             long createrID =course.getCoachID();
             //check the ability first
             if(createrID!=coachid){
                    JOptionPane.showMessageDialog(null, "You don't have permission to delete!");
                    List<Course> myCourse = coachDAO.getMyCourse(coachid);
                    hsr.setAttribute("myCourse", myCourse);
                    mv= new ModelAndView("coachCourse","myCourse", myCourse);
             }else{
                   int result= coachDAO.deleteCourse(courseid);
                   if (result==1){
                       List<Course> myCourse = coachDAO.getMyCourse(coachid);
                       hsr.setAttribute("myCourse", myCourse);
                       mv= new ModelAndView("coachCourse","myCourse", myCourse);
                   }else{
                       JOptionPane.showMessageDialog(null, "Error happens when delete!");
                       List<Course> myCourse = coachDAO.getMyCourse(coachid);
                       hsr.setAttribute("myCourse", myCourse);
                       mv= new ModelAndView("coachCourse","myCourse", myCourse);
                   }
             }
           return mv;
    }
      
      
}
