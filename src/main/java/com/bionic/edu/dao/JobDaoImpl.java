package com.bionic.edu.dao;

import com.bionic.edu.entity.Group;
import com.bionic.edu.entity.Job;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
}
