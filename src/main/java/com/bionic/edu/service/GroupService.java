package com.bionic.edu.service;


import com.bionic.edu.entity.Group;

import java.util.List;

public interface GroupService {

    void save(Group group);

    List<Group> getAll();

    Group findById(int n);

    void update(Group group1);

}
