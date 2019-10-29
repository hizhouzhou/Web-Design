/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.exception;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zhouzhou
 */
public class PersonException extends Exception{

    public PersonException(String message) {
        super(message);
    }
    
    public PersonException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}

