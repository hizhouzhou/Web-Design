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
import zzz.dao.CourseDAO;
import zzz.pojo.Course;

/**
 *
 * @author zhouzhou
 */
public class searchController extends AbstractController{
    
    CourseDAO courseDAO;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       
         ModelAndView mv=null;
        
         courseDAO= (CourseDAO)getApplicationContext().getBean("coursedao");
         
          String level=hsr.getParameter("level");
          String search =hsr.getParameter("search");
          if(level!=null && level.length()!=0){
          List<Course> searchLevel =courseDAO.searchLevel(level);
        
          hsr.setAttribute("searchCourse", searchLevel);
        mv=new ModelAndView("searchResult","searchCourse",searchLevel);
          }else{
         List<Course> searchCourse =courseDAO.searchCourse(search);
        hsr.setAttribute("searchCourse", searchCourse);
        mv=new ModelAndView("searchResult","searchCourse",searchCourse);
          }    
        return mv;
    }
    
    
    
}
