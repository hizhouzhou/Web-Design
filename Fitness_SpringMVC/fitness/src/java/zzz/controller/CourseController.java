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
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import zzz.dao.CoachDAO;

import zzz.dao.CourseDAO;
import zzz.pojo.Coach;

import zzz.pojo.Course;


/**
 *
 * @author zhouzhou
 */
public class CourseController extends SimpleFormController{
    
    CourseDAO courseDAO;
    CoachDAO coachDAO;

    public CourseController() {
        setCommandClass(Course.class);
        setCommandName("course");
        setSuccessView("coachCourse");
        setFormView("addCourse"); 
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        HttpSession session=request.getSession();
        ModelAndView mv;
        
        
        courseDAO =(CourseDAO)getApplicationContext().getBean("coursedao");
        coachDAO =(CoachDAO)getApplicationContext().getBean("coachdao");
        Course course =(Course) command;
        
       Coach coach=(Coach)session.getAttribute("Coach");
//       assign id
      long coachid=coach.getCoachID();
       course.setCoachID(coachid);
//       assign correct coverurl
        String url=course.getCoverurl();
        String correct="./css/images/"+url;
        System.out.println(correct);
        course.setCoverurl(correct);
        
        String videourl =course.getUrl();
  
        String correctvideo =videourl.replace("watch?v=", "embed/");
         System.out.println(correctvideo);
         course.setUrl(correctvideo);

        int result =courseDAO.add(course);
  
        
        if(result==1){
            System.out.println("save success");
            Course cc= new Course(course.getCoachID(),course.getUrl(), course.getName(), course.getDescription(), course.getLevel(),course.getCoverurl());
           
             List<Course> myCourse = coachDAO.getMyCourse(coachid);
             request.setAttribute("myCourse", myCourse);
              session.setAttribute("myCourse", myCourse);
            mv= new ModelAndView(getSuccessView(),"myCourse", myCourse);
            
        }else{
            System.out.println("save fail");
            mv= new ModelAndView(new RedirectView("course.htm"));
  
    }
        return mv;
    
    }  
    
  
}
