package com.bionic.edu.service;

import com.bionic.edu.entity.Students;

import java.util.List;

public interface StudentsService {

    void save(Students student);

    Students findByLoginPass(String login, String pass);

    List<Students> getAll();

    Students findById(int n);

    void update(Students student1);

    boolean isLoginExist(String login);
}
