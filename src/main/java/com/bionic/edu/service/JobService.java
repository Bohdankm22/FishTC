package com.bionic.edu.service;

import com.bionic.edu.entity.Job;

import java.util.List;

public interface JobService {

    void save(Job job);

    List<Job> getAll();

    Job findById(int n);

    void update(Job job1);

    List<Job> getStudentJobsById(int id);
}
