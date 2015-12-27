package com.bionic.edu.dao;

import com.bionic.edu.entity.Job;
import com.bionic.edu.entity.Lesson;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JobDaoImpl implements JobDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Job job) {
        em.persist(job);
    }

    @Override
    public List<Job> getAll() {
        String txt = "SELECT u FROM Job u";
        TypedQuery<Job> querry = em.createQuery(txt, Job.class);
        return querry.getResultList();
    }

    @Override
    public Job findById(int id) {
        return em.find(Job.class, id);
    }

    @Override
    public void update(Job job1) {
        Job job2 = em.find(Job.class, job1.getJob_id());
        if (job2 != null) {
            em.merge(job1);
        }
    }

    @Override
    public List<Job> getStudentJobsById(int id) {
        String txt = "select JOB.Job_id, job.job_title, JOB.JOB_DESCRIPTION, job.LESSON_ID, JOB.JOB_ISDELETED  " +
                "FROM STUDENTS, GROUPS, STUDENTS_IN_GROUPS, SPECIALIZATION, SPEC_LESSON, LESSON, JOB " +
                "WHERE STUDENTS.STUDENTS_ID=STUDENTS_IN_GROUPS.STUDENTSINGROUPS_STUDENTS_ID " +
                "AND STUDENTS_IN_GROUPS.STUDENTSINGROUPS_GROUPS_ID=GROUPS.GROUPS_ID " +
                "AND SPECIALIZATION.SPECIALIZATION_ID=GROUPS.SPECIALIZATION_ID " +
                "AND SPECIALIZATION.SPECIALIZATION_ID=SPEC_LESSON.SPECLESSON_SPECIALIZATION_ID " +
                "AND SPEC_LESSON.SPECLESSON_LESSON_ID=LESSON.LESSON_ID AND LESSON.LESSON_ID=JOB.LESSON_ID " +
                "AND STUDENTS.STUDENTS_ID=" + id + "";
        Query query = em.createNativeQuery(txt);
        List<Object[]> list = query.getResultList();
        List<Job> result = new ArrayList<Job>();
        for (Object[] o : list) {
            Job job = new Job();
            job.setJob_id(Integer.parseInt(((BigDecimal) o[0]).toString()));
            job.setJob_Title((String) o[1]);
            job.setJob_Description((String) o[2]);
            boolean res = Integer.parseInt(((BigDecimal) o[4]).toString()) != 0;
            job.setJob_isDeleted(res);
            Lesson lesson = new Lesson();
            lesson.setLesson_id(Integer.parseInt(((BigDecimal) o[3]).toString()));
            job.setLesson(lesson);
            result.add(job);
        }

        return result;
    }

}
