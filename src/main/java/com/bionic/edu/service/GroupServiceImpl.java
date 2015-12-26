package com.bionic.edu.service;

import com.bionic.edu.dao.GroupDao;
import com.bionic.edu.entity.Groups;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class GroupServiceImpl implements GroupService {

    @Inject
    private GroupDao groupDao;

    @Override
    @Transactional
    public void save(Groups groups){
        groupDao.save(groups);
    }

    @Override
    public List<Groups> getAll() {
        return groupDao.getAll();
    }

    @Override
    public Groups findById(int n) {
        return groupDao.findById(n);
    }

    @Override
    @Transactional
    public void update(Groups groups) {
        groupDao.update(groups);
    }

    @Override
    public boolean isGroupNameExists(String name) {
        return groupDao.findByName(name) != null;
    }
}
