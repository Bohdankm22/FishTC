package com.bionic.edu.dao;

import com.bionic.edu.entity.Students;

import java.util.List;

public interface StudentsDao {

    void save(Students students);

    Students findByLogin(String login);

    List<Students> getAll();

    Students findById(int id);

    void update(Students user1);
}
