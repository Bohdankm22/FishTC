package com.bionic.edu.service;


import com.bionic.edu.entity.Groups;

import java.util.List;

public interface GroupService {

    void save(Groups groups);

    List<Groups> getAll();

    Groups findById(int n);

    void update(Groups groups1);

    boolean isGroupNameExists(String name);

}
