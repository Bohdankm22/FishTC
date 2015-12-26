package com.bionic.edu.service;

import com.bionic.edu.dao.GroupDao;
import com.bionic.edu.entity.Group;
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
    public void save(Group group){
        groupDao.save(group);
    }

    @Override
    public List<Group> getAll() {
        return groupDao.getAll();
    }

    @Override
    public Group findById(int n) {
        return groupDao.findById(n);
    }

    @Override
    @Transactional
    public void update(Group group) {
        groupDao.update(group);
    }
}
