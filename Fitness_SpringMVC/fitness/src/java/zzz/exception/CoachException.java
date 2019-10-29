/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.exception;

/**
 *
 * @author zhouzhou
 */
public class CoachException extends Exception{

    public CoachException(String message) {
        super(message);
    }

    public CoachException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
