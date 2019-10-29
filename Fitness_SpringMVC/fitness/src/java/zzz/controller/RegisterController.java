/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
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
public class RegisterController extends  SimpleFormController{
    
    PersonDAO personDAO;
    
        public RegisterController(){
        setCommandClass(Person.class);
        setCommandName("register");
   //     setSuccessView("login");
        setFormView("register");

}

        

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, org.springframework.validation.BindException errors) throws Exception{
       HttpSession session = request.getSession();
        ModelAndView mv;
        
        personDAO = (PersonDAO) getApplicationContext().getBean("persondao");
        Person p = (Person) command;
     int duplication=personDAO.duplicateVerify(p.getUserName());
     
  
      if(duplication==1){
          //setSuccessView("login");
          session.setAttribute("message", "This account name has been used, choose a new one");
       //现在会抛出很丑陋的异常。
         mv = new ModelAndView(new RedirectView("register.htm"));
         return mv;       
    }else{
             int result= personDAO.add(p);
        
        if (result== 1) {
                     String role=p.getPersonType();
                  if(role.equals("User")){
                      User u = new User(p.getUserName(),p.getPassword(),p.getPersonType());
                      personDAO.addUser(u);
                   session.setAttribute("User", u);
                   setSuccessView("UserPage");
                     mv = new ModelAndView(getSuccessView(),"User",u);
                     return mv;
                  }else if(role.equals("Coach")){
                      Coach c= new Coach(p.getUserName(),p.getPassword(),p.getPersonType());
                      personDAO.addCoach(c);
                       session.setAttribute("Coach", c);
                   setSuccessView("CoachPage");
                   mv = new ModelAndView(getSuccessView(),"Coach",c);
                    return mv;
                  }
                    mv = new ModelAndView(getSuccessView(),"Person",p);
                } else {
                    mv = new ModelAndView(new RedirectView("register.htm"));
                }
      }

return mv;
        
}
    }
        