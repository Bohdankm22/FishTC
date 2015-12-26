package com.bionic.edu.dao;

import com.bionic.edu.entity.Students;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentsDaoImpl implements StudentsDao{
    @PersistenceContext
    private EntityManager em;

    public void save(Students students){
        em.persist(students);
    }

    @Override
    public Students findByLogin(String login){
        Students student = null;
        String txt = "SELECT u FROM Students u WHERE u.Students_Login='" + login + "'";
        TypedQuery<Students> querry = em.createQuery(txt, Students.class);
        try{
            student = querry.getSingleResult();
        }
        catch(NoResultException e){
//            LOG.info("No student found with login " + name);
        }
        return student;
    }

    @Override
    public List<Students> getAll() {
        String txt = "SELECT u FROM Students u";
        TypedQuery<Students> querry = em.createQuery(txt, Students.class);
        return querry.getResultList();
    }

    @Override
    public Students findById(int id) {
        return em.find(Students.class, id);
    }

    @Override
    public void update(Students student1) {
        Students student2 = em.find(Students.class, student1.getStudents_id());
        if (student2 != null) {
            em.merge(student1);
        }

    }

}
