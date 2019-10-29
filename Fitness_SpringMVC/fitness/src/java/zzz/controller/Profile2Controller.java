/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import zzz.dao.CoachDAO;
import zzz.dao.UserDAO;
import zzz.pojo.Coach;
import zzz.pojo.User;

/**
 *
 * @author zhouzhou
 */
public class Profile2Controller extends SimpleFormController{
    
    CoachDAO coachDAO;

    public Profile2Controller() {
        
        setCommandClass(Coach.class);
        setCommandName("coachprofile");
          setSuccessView("coachProfile");
        setFormView("edit2Profile");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
         HttpSession session = request.getSession();
        ModelAndView mv = null;
       
       coachDAO=(CoachDAO) getApplicationContext().getBean("coachdao");
       Coach u=(Coach) command;
   int update =coachDAO.updateCoach(u.getCoachID(),u.getHeight(),u.getWeight(),u.getAge(),u.getGender());
     
        if(update==0){
             mv = new ModelAndView(new RedirectView("profile2.htm"));
        }else{
            session.setAttribute("Coach", u);
              mv = new ModelAndView(getSuccessView(),"Coach",u);
        
        }   
       
       return mv;
    }
  
    
}
