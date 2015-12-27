package com.bionic.edu.dao;

import com.bionic.edu.entity.Lesson;

import java.util.List;

public interface LessonDao {

    void save(Lesson lesson);

    List<Lesson> getAll();

    Lesson findById(int id);

    void update(Lesson lesson1);

    List<Lesson> getStudentLessons(int id);
}
