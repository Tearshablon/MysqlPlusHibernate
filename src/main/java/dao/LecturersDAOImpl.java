package dao;

import entity.Lecturers;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class LecturersDAOImpl implements LecturersDAO {

    private static final Logger log = Logger.getLogger(CoursesDAOImpl.class);

    @Override
    public void addLecturers(Lecturers lecturers) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(lecturers);
            session.getTransaction().commit();
            log.info("Lecturers Successfully add " + lecturers);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public List<Lecturers> getAllLecturers() {
        List<Lecturers> lecturers = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Lecturers.class);
            lecturers = criteria.list();
            for (Lecturers lecturers1: lecturers) {
                log.info("Lecturers list " + lecturers1);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return lecturers;
    }

    @Override
    public Lecturers getLecturersById(int id) {
        Lecturers lecturers = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            lecturers = (Lecturers) session.load(Lecturers.class, new Long(id));
            session.getTransaction().commit();
            log.info("Student Successfully getById " + lecturers);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return lecturers;
    }

    @Override
    public void updateLecturers(Lecturers lecturers) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(lecturers);
            session.getTransaction().commit();
            log.info("Lecturers Successfully update " + lecturers);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteLecturersById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Lecturers lecturers = (Lecturers) session.load(Lecturers.class, new Long(id));
            if(lecturers != null){
                session.delete(lecturers);
            }
            session.getTransaction().commit();
            log.info("Lecturer Successfully delete " + lecturers);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
