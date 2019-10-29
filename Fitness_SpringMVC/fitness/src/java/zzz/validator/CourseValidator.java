/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import zzz.pojo.Course;

/**
 *
 * @author zhouzhou
 */
public class CourseValidator implements Validator{

    @Override
    public boolean supports(Class aClass) {
       return Course.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "error.url.required", "url required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name.required", "name required");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.description.required", "description required");
           ValidationUtils.rejectIfEmptyOrWhitespace(errors, "coverurl", "error.coverurl.required", "picture required");
 
         if(errors.hasErrors())
                 return;
    }
    
    
}
