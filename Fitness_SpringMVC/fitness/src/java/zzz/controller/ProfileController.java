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
import zzz.dao.PersonDAO;
import zzz.dao.UserDAO;
import zzz.pojo.User;

/**
 *
 * @author zhouzhou
 */
public class ProfileController extends SimpleFormController{
    
     UserDAO userDAO;

    public ProfileController() {
     setCommandClass(User.class);
        setCommandName("userprofile");
      setSuccessView("userProfile");
        setFormView("editProfile");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
       HttpSession session = request.getSession();
        ModelAndView mv = null;
       
       userDAO=(UserDAO) getApplicationContext().getBean("userdao");
       User u =(User) command;
       
   int update =userDAO.updateUser(u.getUserID(),u.getHeight(),u.getWeight(),u.getAge(),u.getGender());
                
     
        if(update==0){
             mv = new ModelAndView(new RedirectView("profile.htm"));
        }else{
            session.setAttribute("User", u);
              mv = new ModelAndView(getSuccessView(),"User",u);
        
        }   
       
       return mv;
    }
     
    
    
}
