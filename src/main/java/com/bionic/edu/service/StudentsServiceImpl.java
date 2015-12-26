package com.bionic.edu.service;

import com.bionic.edu.dao.StudentsDao;
import com.bionic.edu.entity.Students;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StudentsServiceImpl implements StudentsService {

    @Inject
    private StudentsDao studentsDao;

    @Override
    @Transactional
    public void save(Students student){
        studentsDao.save(student);
    }

    @Override
    public Students findByLoginPass(String login, String pass){
        Students u = studentsDao.findByLogin(login);
        if(u != null && u.getStudents_password().equals(pass)) {
            return u;
        }
        return null;
    }

    @Override
    public List<Students> getAll() {
        return studentsDao.getAll();
    }

    @Override
    public Students findById(int n) {
        return studentsDao.findById(n);
    }

    @Override
    @Transactional
    public void update(Students student) {
        studentsDao.update(student);
    }

    @Override
    public boolean isLoginExist(String login){
        return studentsDao.findByLogin(login) != null;
    }
}
