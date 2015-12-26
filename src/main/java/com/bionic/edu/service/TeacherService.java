package com.bionic.edu.service;

import com.bionic.edu.entity.Teacher;

import java.util.List;

public interface TeacherService {

    void save(Teacher teacher);

    List<Teacher> getAll();

    Teacher findById(int n);

    void update(Teacher teacher1);
}
