package com.bionic.edu.service;

import com.bionic.edu.dao.JobDao;
import com.bionic.edu.dao.LessonDao;
import com.bionic.edu.entity.Job;
import com.bionic.edu.entity.Lesson;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class JobServiceImpl implements JobService {

    @Inject
    private JobDao jobDao;
    @Inject
    private LessonDao lessonDao;

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

    @Override
    @Transactional
    public List<Job> getStudentJobsById(int id) {
        List<Job> result = jobDao.getStudentJobsById(id);
        for (Job job : result) {
            Lesson lesson = lessonDao.findById(job.getLesson().getLesson_id());
            lesson.setSpecLesson(new ArrayList<>());
            job.setLesson(lesson);
        }
        return result;
    }
}
