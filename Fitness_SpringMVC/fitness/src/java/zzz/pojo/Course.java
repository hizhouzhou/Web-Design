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
public class Course {
    private long courseID;
    private long coachID;
    private String url;
    private String name;
    private String description;
    private String  level;
    private String coverurl;
    private Set<User> users =new HashSet();

    public Course() {
    }

  
    public Course(long coachID,String url, String name, String description, String level, String coverurl) {
        this.coachID=coachID;
        this.url = url;
        this.name = name;
        this.description = description;
        this.level = level;
    }
    

 
    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }


    public long getCoachID() {
        return coachID;
    }

    public void setCoachID(long coachID) {
        this.coachID = coachID;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl;
    }
    

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", name=" + name + '}';
    }
    
    
    
}
