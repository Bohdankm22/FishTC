package com.bionic.edu.dao;

import com.bionic.edu.entity.Job;

import java.util.List;

public interface JobDao {

    void save(Job job);

    List<Job> getAll();

    Job findById(int id);

    void update(Job job1);
}
