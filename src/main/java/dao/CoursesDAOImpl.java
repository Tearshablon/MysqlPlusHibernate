package dao;

import entity.Courses;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.management.Query;
import java.util.List;


public class CoursesDAOImpl implements CoursesDAO {

    private static final Logger log = Logger.getLogger(CoursesDAOImpl.class);
    @Override
    public void addCourses(Courses courses) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(courses);
            session.getTransaction().commit();
            log.info("Courses successfully add " + courses);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Courses> getAllCourses() {
        List<Courses> courses = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Courses.class);
            courses = criteria.list();
            for (Courses courses1: courses) {
                log.info("Courses list " + courses1);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return courses;
    }

    @Override
    public Courses getCoursesById(int id) {
        Courses courses = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            courses = (Courses) session.load(Courses.class, new Long(id));
            session.getTransaction().commit();
            log.info("Course Successfully getById " + courses);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return courses;
    }

    @Override
    public void updateCourses(Courses courses) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(courses);
            session.getTransaction().commit();
            log.info("Courses Successfully update " + courses);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCoursesById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Courses courses = (Courses) session.load(Courses.class, new Long(id));
            if(courses !=  null){
                session.delete(courses);
            }
            session.getTransaction().commit();
            log.info("Course Successfully delete " + courses);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
