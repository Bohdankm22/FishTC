package com.bionic.edu.dao;

import com.bionic.edu.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    void save(Teacher teacher);

    List<Teacher> getAll();

    Teacher findById(int id);

    void update(Teacher teacher1);
}
