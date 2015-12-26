package com.bionic.edu.dao;

import com.bionic.edu.entity.Group;
import com.bionic.edu.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Teacher teacher) {
        em.persist(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        String txt = "SELECT u FROM Teacher u";
        TypedQuery<Teacher> querry = em.createQuery(txt, Teacher.class);
        return querry.getResultList();
    }

    @Override
    public Teacher findById(int id) {
        return em.find(Teacher.class, id);
    }

    @Override
    public void update(Teacher teacher1) {
        Teacher teacher2 = em.find(Teacher.class, teacher1.getTeacher_id());
        if (teacher2 != null) {
            em.merge(teacher1);
        }
    }
}
