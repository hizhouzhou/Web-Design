/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.dao;

import java.util.List;

import org.hibernate.Query;
import static zzz.dao.DAO.getSession;
import zzz.exception.CoachException;

import zzz.pojo.Coach;
import zzz.pojo.Course;

/**
 *
 * @author zhouzhou
 */
public class CoachDAO extends DAO{

    public CoachDAO() {
    }
    
         public int updateCoach(long coachID, Double height, Double weight,int age,String gender)throws CoachException{
          int result; 
         try{
            super.begin();
            
           String hql="update Coach u set u.height=:height,u.weight=:weight,u.age=:age,u.gender=:gender where u.coachID=:coachID";
           Query query =getSession().createQuery(hql);
           query.setLong("coachID", coachID);
     
           query.setDouble("height", height);
           query.setDouble("weight", weight);
           query.setInteger("age", age);
           query.setString("gender", gender);
//           query.setMaxResults(1);
           result=query.executeUpdate();
           super.commit();
           
    }catch(Exception e){
        super.rollback();
        throw new CoachException("Could not update coach",e);
    }
      return result;
}
         
         public Course addCourse(Course course) throws CoachException{
             
             try{
                 super.begin();
                 getSession().save(course);
                super.commit();
             }catch(Exception e){
                 super.rollback();
                 throw new CoachException("coach add course fail",e);
         }
             return course;
}
         
         public Coach getCoach(long coachID)throws CoachException{
             Coach c;
             try{
                 super.begin();
                 String hql="from Coach where coachID=:coachID";
                 Query query = getSession().createQuery(hql);
                 query.setLong("coachID", coachID);
                 query.setMaxResults(1);
                 c=(Coach)query.uniqueResult();
                 super.commit();
                 return c;
             }catch(Exception e){
                  super.rollback();
                 throw new CoachException("cannot find this coach",e);
             }
             
         }
         
//         get my course
         public List<Course> getMyCourse(long coachID)throws CoachException{
             List list=null;
             try{
                 super.begin();
                 String hql ="from Course where coachID=:coachID";
                 Query query=getSession().createQuery(hql);
                 query.setLong("coachID", coachID);
                 list=query.list();
                 super.commit();
             }catch(Exception e){
                 super.rollback();
                 throw new CoachException("get my course fail",e);
         }
             return list;

}
         
//         get all course
          public List getAllCourse()throws CoachException{
             List list;
             try{
                 super.begin();
                 String hql ="from Course";
                 Query query=getSession().createQuery(hql);
                 list=query.list();
                 super.commit();
             }catch(Exception e){
                 super.rollback();
                 throw new CoachException("get all course fail",e);

         }
             return list;

}
          
          //delete the course
        public int deleteCourse(long courseID)throws CoachException{
          int result; 
         try{
            super.begin();
            
           String hql="DELETE FROM Course WHERE courseID =:courseID";
           Query query =getSession().createQuery(hql);
           
           //check the reference..
           query.setLong("courseID", courseID);
           result=query.executeUpdate();
           super.commit();
           
    }catch(Exception e){
        super.rollback();
        throw new CoachException("Could not delete course",e);
    }
      return result;
}
}