package com.bionic.edu.dao;

import com.bionic.edu.entity.Group;

import java.util.List;

public interface GroupDao {

    void save(Group group);

    List<Group> getAll();

    Group findById(int id);

    void update(Group group1);
}
