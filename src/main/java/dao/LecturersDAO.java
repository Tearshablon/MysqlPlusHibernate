package dao;

import entity.Lecturers;

import java.util.List;

public interface LecturersDAO {

    void addLecturers(Lecturers lecturers);

    List<Lecturers> getAllLecturers();

    Lecturers getLecturersById(int id);

    void updateLecturers(Lecturers lecturers);

    void deleteLecturersById(int id);

}
