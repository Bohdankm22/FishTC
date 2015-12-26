package com.bionic.edu.service;

import com.bionic.edu.dao.JobDao;
import com.bionic.edu.entity.Job;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class JobServiceImpl implements JobService {

    @Inject
    private JobDao jobDao;

    @Override
    @Transactional
    public void save(Job job){
        jobDao.save(job);
    }

    @Override
    public List<Job> getAll() {
        return jobDao.getAll();
    }

    @Override
    public Job findById(int n) {
        return jobDao.findById(n);
    }

    @Override
    @Transactional
    public void update(Job job) {
        jobDao.update(job);
    }
}
