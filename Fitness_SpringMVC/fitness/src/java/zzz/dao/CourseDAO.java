/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zzz.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import zzz.exception.CourseException;
import zzz.pojo.Course;


/**
 *
 * @author zhouzhou
 */
public class CourseDAO extends DAO{

    public CourseDAO() {
    }
    
//    add new course to database
    public int add(Course p) throws CourseException{
         int result=0;
        try{
           super.begin();
            getSession().save(p);
            super.commit();
            result=1;
    }catch(Exception e){
        super.rollback();
        throw new CourseException("Add course fail",e);
    }
        return result;
   }
    
//    get detail through the course id
    public Course getCourseDetail(long courseID) throws CourseException{
        Course course;
        try{
            super.begin();
            String hql="from Course where courseID=:courseID";
            Query query = getSession().createQuery(hql);
            query.setLong("courseID", courseID);
            course=(Course)query.uniqueResult();
            super.commit();
        }catch(Exception e){
                 super.rollback();
                 throw new CourseException("get course detail fail",e);
         }
        return course;
    }
    
    //return the course that match the search content
    public List<Course> searchCourse(String search) throws CourseException{
         List list=null;
             try{
                 super.begin();
                 Criteria crit =getSession().createCriteria(Course.class);
                 Criterion nameMatch =Restrictions.ilike("name", search,MatchMode.ANYWHERE);
                 Criterion descriptionMatch =Restrictions.ilike("description", search,MatchMode.ANYWHERE);
                 Criterion levelMatch =Restrictions.ilike("level", search,MatchMode.ANYWHERE);
                 Disjunction disjunction =Restrictions.disjunction();
                 disjunction.add(nameMatch);
                 disjunction.add(descriptionMatch);
                 disjunction.add(levelMatch);
                 crit.add(disjunction);
                 list =crit.list();
                 super.commit();
             }catch(Exception e){
                 super.rollback();
                 throw new CourseException("get the  search course fail",e);
         }
             return list;

        
    }
    
    //search by level
     public List<Course> searchLevel(String level) throws CourseException{
      List list=null;
             try{
                 super.begin();
                 Criteria crit =getSession().createCriteria(Course.class);
                 Criterion levelMatch =Restrictions.ilike("level", level,MatchMode.EXACT);
                 crit.add(levelMatch);
                 list =crit.list();
                 super.commit();
             }catch(Exception e){
                 super.rollback();
                 throw new CourseException("get the search level course fail",e);
         }
             return list;

     }
}
