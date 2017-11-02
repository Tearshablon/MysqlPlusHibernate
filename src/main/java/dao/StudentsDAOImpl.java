package dao;

import entity.Students;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class StudentsDAOImpl implements StudentsDAO {

    private static final Logger log = Logger.getLogger(CoursesDAOImpl.class);

    @Override
    public void addStudents(Students students) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(students);
            session.getTransaction().commit();
            log.info("Students Successfully add " + students);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Students> getAllStudents() {
        List<Students> students = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Students.class);
            students = criteria.list();
            for (Students students1: students) {
                log.info("Students list " + students);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return students;
    }

    @Override
    public Students getStudentsById(int id) {
        Students students = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            students = (Students) session.load(Students.class, new Long(id));
            session.getTransaction().commit();
            log.info("Student Successfully getById " + students);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Students students) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(students);
            session.getTransaction().commit();
            log.info("Students Successfully update " + students);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Students students = (Students) session.load(Students.class, new Long(id));
            if(students != null) {
                session.delete(students);
            }
            session.getTransaction().commit();
            log.info("Students Successfully delete " + students);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
