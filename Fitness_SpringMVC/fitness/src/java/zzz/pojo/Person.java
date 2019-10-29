/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.pojo;

/**
 *
 * @author zhouzhou
 */
public class Person {
    
     private long personID;
     private String personType;
    private String userName;
    private String password;

    public Person() {
    }

    
      public Person(String userName,String password,String type) {
        this.userName=userName;
        this.password=password;
        this.personType=type;
    }

       public Person(String userName,String type){
        this.userName=userName;
        this.personType=type;
    }



    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

   
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
