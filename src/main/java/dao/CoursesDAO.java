package dao;

import entity.Courses;

import java.util.List;

public interface CoursesDAO {

    void addCourses(Courses courses);

    List<Courses> getAllCourses();

    Courses getCoursesById(int id);

    void updateCourses(Courses courses);

    void deleteCoursesById(int id);
}
