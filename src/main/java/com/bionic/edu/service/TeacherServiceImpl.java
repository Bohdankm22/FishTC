package com.bionic.edu.service;

import com.bionic.edu.dao.TeacherDao;
import com.bionic.edu.entity.Teacher;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TeacherServiceImpl implements TeacherService {

    @Inject
    private TeacherDao teacherDao;

    @Override
    @Transactional
    public void save(Teacher teacher){
        teacherDao.save(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.getAll();
    }

    @Override
    public Teacher findById(int n) {
        return teacherDao.findById(n);
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

}
