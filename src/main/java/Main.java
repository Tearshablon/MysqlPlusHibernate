
import dao.CoursesDAO;
import dao.FactoryDAOImpl;
import dao.StudentsDAOImpl;
import entity.Courses;
import entity.Lecturers;
import entity.Students;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Students> students = FactoryDAOImpl.getInstance().getStudentsDAO().getAllStudents();
        List<Lecturers> lecturers = FactoryDAOImpl.getInstance().getLecturersDAO().getAllLecturers();
        List<Courses> courses = FactoryDAOImpl.getInstance().getCoursesDAO().getAllCourses();
    }
}
