package com.bionic.edu.service;


import com.bionic.edu.entity.Lesson;

import java.util.List;

public interface LessonService {

    void save(Lesson lesson);

    List<Lesson> getAll();

    Lesson findById(int n);

    void update(Lesson lesson1);
}
