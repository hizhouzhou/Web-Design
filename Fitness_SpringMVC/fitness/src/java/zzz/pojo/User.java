/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.pojo;

import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author zhouzhou
 */
public class User extends Person{

   private long userID;
    private double height;
    private double weight;
    private int age;
    private String gender;
    private Set<Course> courses =new HashSet();
    
    public User() {
    }

    public User(String userName, String password, String type) {
        super(userName, password, type);
    }

    
    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
   

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

   
 

 
    
    
    
}
