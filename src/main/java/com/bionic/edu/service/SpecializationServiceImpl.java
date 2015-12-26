package com.bionic.edu.service;

import com.bionic.edu.dao.SpecializationDao;
import com.bionic.edu.entity.Specialization;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SpecializationServiceImpl implements SpecializationService {

    @Inject
    private SpecializationDao specializationDao;

    @Override
    @Transactional
    public void save(Specialization specialization){
        specializationDao.save(specialization);
    }

    @Override
    public List<Specialization> getAll() {
        return specializationDao.getAll();
    }

    @Override
    public Specialization findById(int n) {
        return specializationDao.findById(n);
    }

    @Override
    @Transactional
    public void update(Specialization specialization) {
        specializationDao.update(specialization);
    }
}
