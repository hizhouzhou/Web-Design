/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.pojo;

import java.util.Set;

/**
 *
 * @author zhouzhou
 */
public class Coach extends Person{
    
    private long coachID;
    private double height;
    private double weight;
    private int age;
    private String gender;
    private Set<Course> course;

    public Coach() {
    }

    
    public Coach(String userName, String password, String type) {
        super(userName, password, type);
    }

    public long getCoachID() {
        return coachID;
    }

    public void setCoachID(long coachID) {
        this.coachID = coachID;
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

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

  

    @Override
    public String toString() {
        return "Coach{" + "coachID=" + coachID + '}';
    }

}
