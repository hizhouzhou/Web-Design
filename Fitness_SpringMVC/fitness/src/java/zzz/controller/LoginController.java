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
import zzz.exception.PersonException;
import zzz.pojo.Coach;
import zzz.pojo.Person;
import zzz.pojo.User;

/**
 *
 * @author zhouzhou
 */
public class LoginController extends SimpleFormController{
    
   
     PersonDAO personDAO;
        public LoginController(){
            
       setCommandClass(Person.class);
        setCommandName("login");
//        setSuccessView("login-success");
        setFormView("login");
}

        
  
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception {
        HttpSession session = request.getSession();
        
        ModelAndView mv;
        
        personDAO = (PersonDAO) getApplicationContext().getBean("persondao");
        Person p = (Person) command;
//        String type=p.getPersonType();
  
//      if(type.equals("User")){
       User loginu=personDAO.authenticateLogin(p.getUserName(), p.getPassword());
       if (loginu== null) {
            mv = new ModelAndView(new RedirectView("login.htm"));
//             return mv;
       }else{
            session.setAttribute("User", loginu);
                   setSuccessView("UserPage");
                    mv = new ModelAndView(getSuccessView(),"User",loginu);
                    return mv;
       }
//    }else if(type.equals("Coach")){
           Coach loginc=personDAO.authenticateLogin2(p.getUserName(), p.getPassword());
            if (loginc== null) {
            mv = new ModelAndView(new RedirectView("login.htm"));
//             return mv;
       }else{
            session.setAttribute("Coach", loginc);
             setSuccessView("CoachPage");
             mv = new ModelAndView(getSuccessView(),"Coach",loginc);
              return mv;
       }
//    }
       
//         mv = new ModelAndView(getSuccessView(),"Person",p);
                
      return mv;
        
}
   
}

