package com.bionic.edu.service;

import com.bionic.edu.dao.GroupDao;
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

    @Inject
    private GroupDao groupDao;

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
    @Transactional
    public List<Students> getAll() {
        List<Students> result = studentsDao.getAll();
        for (Students students : result) {
            students.setStudentsInGroups(groupDao.getGroupsByStudentId(students.getStudents_id()));
        }
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
