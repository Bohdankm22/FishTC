package com.bionic.edu.dao;

import com.bionic.edu.entity.Groups;

import java.util.List;

public interface GroupDao {

    void save(Groups groups);

    List<Groups> getAll();

    Groups findById(int id);

    void update(Groups groups1);

    Groups findByName(String name);
}
