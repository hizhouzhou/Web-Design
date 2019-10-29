/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.dao;


import java.util.List;
import org.hibernate.Query;
import zzz.exception.PersonException;
import zzz.pojo.Coach;
import zzz.pojo.Person;
import zzz.pojo.User;

/**
 *
 * @author zhouzhou
 */
public class PersonDAO extends DAO {

    public PersonDAO() {
    }
    
    public int add(Person p)throws PersonException{
        int result=0;
         try{
            super.begin();
            getSession().save(p);
            
            super.commit();
            result=1;
    }catch(Exception e){
        super.rollback();
        throw new PersonException("Could not get person"+p.getUserName(),e);
    }
        return result;
}
    
     public User addUser(User u)throws PersonException{
        
         try{
            super.begin();
            getSession().save(u);
            
            super.commit();
           
    }catch(Exception e){
        super.rollback();
        throw new PersonException("Could not get user"+u.getUserName(),e);
    }
        return u;
}
     
     public Coach addCoach(Coach c)throws PersonException{
        
         try{
            super.begin();
            getSession().save(c);
            
            super.commit();
  
    }catch(Exception e){
        super.rollback();
        throw new PersonException("Could not get coach"+c.getUserName(),e);
    }
        return c;
}
    
    
     public User authenticateLogin(String userName, String password) throws  PersonException {
         User p;
        try {
           super.begin();
           //hql的from后面是对象Person，而不是数据库的表名 person
           String hql="from User where userName=:userName AND password=:password";
           Query query =getSession().createQuery(hql);
           query.setString("userName", userName);
           query.setString("password", password);
           query.setMaxResults(1);
           p=(User)query.uniqueResult();
           super.commit();
           return p;
        } catch (Exception e) {
             super.rollback();
           throw new PersonException("Cant match the username and password",e);
        }
    }
     
         public Coach authenticateLogin2(String userName, String password) throws  PersonException {
            Coach p;
        try {
           super.begin();
           //hql的from后面是对象Person，而不是数据库的表名 person
           String hql="from Coach where userName=:userName AND password=:password";
           Query query =getSession().createQuery(hql);
           query.setString("userName", userName);
           query.setString("password", password);
           query.setMaxResults(1);
           p=(Coach)query.uniqueResult();
           super.commit();
           return p;
        } catch (Exception e) {
             super.rollback();
           throw new PersonException("Cant match the username and password",e);
        }
    }
     
     public int duplicateVerify(String userName)throws PersonException{
         int duplication=0;
         try{
              super.begin();
               String hql="from Person where userName=:userName";
                Query query =getSession().createQuery(hql);
                 query.setString("userName", userName);
                 query.setMaxResults(1); 
                  List l=query.list();
//                  verify the duplication,if yes,duplication changes to 1
                  if(l==null  || l.isEmpty()){
                      duplication=0;
                  }else{
                      duplication=1;
                  }
                   super.commit();      
         }catch (Exception e) {
             super.rollback();
          throw new PersonException("This username has been used.",e);
        }

         return duplication;
     }
 
        
    }
