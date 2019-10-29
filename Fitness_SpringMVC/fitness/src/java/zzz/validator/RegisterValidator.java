/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import zzz.pojo.Person;

/**
 *
 * @author zhouzhou
 */
public class RegisterValidator implements Validator{

    @Override
    public boolean supports(Class aClass) {
        return Person.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.userName.required", "userName required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.required", "password required");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors,"personType","error.personType.required","please select a role");
         if(errors.hasErrors())
                 return;
    }
    
    
}
