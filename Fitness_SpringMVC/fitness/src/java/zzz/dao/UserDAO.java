/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import static zzz.dao.DAO.getSession;

import zzz.exception.UserException;
import zzz.pojo.Course;
import zzz.pojo.User;


/**
 *
 * @author zhouzhou
 */
public class UserDAO  extends DAO{

    public UserDAO() {
    }
    
      public int updateUser(long userID, Double height, Double weight,int age,String gender)throws UserException{
          int result; 
         try{
            super.begin();
            
           String hql="update User u set u.height=:height,u.weight=:weight,u.age=:age,u.gender=:gender where u.userID=:userID";
           Query query =getSession().createQuery(hql);
           query.setLong("userID", userID);

           query.setDouble("height", height);
           query.setDouble("weight", weight);
           query.setInteger("age", age);
           query.setString("gender", gender);
//           query.setMaxResults(1);
           result=query.executeUpdate();
           super.commit();
           
    }catch(Exception e){
        super.rollback();
        throw new UserException("Could not update user",e);
    }
      return result;
}
      
      //         get all course
          public List getAllCourse()throws UserException{
             List list;
             try{
                 super.begin();
                 String hql ="from Course";
                 Query query=getSession().createQuery(hql);
                 list=query.list();
                 super.commit();
             }catch(Exception e){
                 super.rollback();
                 throw new UserException("get all course fail",e);

         }
             return list;

}
          //get user object by id
           public User getUser(long userID)throws UserException{
             User c;
             try{
                 super.begin();
                 String hql="from User where userID=:userID";
                 Query query = getSession().createQuery(hql);
                 query.setLong("userID", userID);
                 query.setMaxResults(1);
                 c=(User)query.uniqueResult();
                 super.commit();
                 return c;
             }catch(Exception e){
                  super.rollback();
                 throw new UserException("cannot find this user",e);
             }
             
         }
          
          
        //         get my course
         public List<Course> getMyCourse(long userID)throws UserException{
             List<Course> list=null;
             try{
                 super.begin();
                  Criteria crit =getSession().createCriteria(Course.class);
                  Criteria userCrit =crit.createCriteria("users");
                  userCrit.add(Restrictions.eq("userID", userID));
                  list=crit.list();
                 super.commit();
             }catch(Exception e){
                 super.rollback();
                 throw new UserException("get my course fail",e);
         }
             return list;

}  
        
          
//          user subscribe the course
      public void updateSubscribe(User user, Course course)throws UserException{
         try{
           super.begin();
           //add course for user
           Set<Course> userCourses=user.getCourses();
           userCourses.add(course);
           user.setCourses(userCourses);
             System.out.println("Get course:"+user.getCourses());
           //add user for course
           Set<User> courseUsers =course.getUsers();
           courseUsers.add(user);
           course.setUsers(courseUsers);
           System.out.println("Get user:"+course.getUsers());
           getSession().merge(user);
           getSession().merge(course);
           getSession().save(user);
           getSession().save(course);
           super.commit();
    }catch(Exception e){
        super.rollback();
        throw new UserException("Could not subscribe",e);
    }
          }
      //          user cancel subscribe the course
        public void cancelSubscribe (User user, Course course)throws UserException{
            try{
                  super.begin();
//                  user
                   Set<Course> userCourses=user.getCourses();
                   userCourses.remove(course);
                   user.setCourses(userCourses);
//                    course
                    Set<User> courseUsers =course.getUsers();
                    courseUsers.remove(user);
                    course.setUsers(courseUsers);
                    
           getSession().merge(user);
           getSession().merge(course);
           getSession().save(user);
           getSession().save(course);
           super.commit();
                   
            }catch(Exception e){
        super.rollback();
        throw new UserException("Could not cancel subscribe",e);
    }
        }
}