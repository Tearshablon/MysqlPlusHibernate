package dao;

public class FactoryDAOImpl {
    private static CoursesDAO coursesDAO= null;
    private static LecturersDAO lecturersDAO = null;
    private  static StudentsDAO studentsDAO = null;

    private static FactoryDAOImpl instance= null;

    public static FactoryDAOImpl getInstance() {
        if(instance == null){
            instance = new FactoryDAOImpl();
        }
        return instance;
    }

    public CoursesDAO getCoursesDAO() {
        if(coursesDAO == null){
            coursesDAO = new CoursesDAOImpl();
        }
        return coursesDAO;
    }
    public  LecturersDAO getLecturersDAO() {
        if(lecturersDAO == null){
            lecturersDAO = new LecturersDAOImpl();
        }
        return lecturersDAO;
    }

    public  StudentsDAO getStudentsDAO() {
        if(studentsDAO == null){
            studentsDAO = new StudentsDAOImpl();
        }
        return studentsDAO;
    }
}
