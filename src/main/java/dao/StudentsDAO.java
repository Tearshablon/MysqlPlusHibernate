package dao;

import entity.Students;

import java.util.List;

public interface StudentsDAO {

    void addStudents(Students students);

    List<Students> getAllStudents();

    Students getStudentsById(int id);

    void updateStudent(Students students);

    void deleteStudentById(int id);
}
