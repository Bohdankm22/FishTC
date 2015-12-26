package com.bionic.edu.dao;

import com.bionic.edu.entity.Lesson;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LessonDaoImpl implements LessonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Lesson lesson) {
        em.persist(lesson);
    }

    @Override
    public List<Lesson> getAll() {
        String txt = "SELECT u FROM Lesson u";
        TypedQuery<Lesson> querry = em.createQuery(txt, Lesson.class);
        return querry.getResultList();
    }

    @Override
    public Lesson findById(int id) {
        return em.find(Lesson.class, id);
    }

    @Override
    public void update(Lesson lesson1) {
        Lesson lesson2 = em.find(Lesson.class, lesson1.getLesson_id());
        if (lesson2 != null) {
            em.merge(lesson1);
        }
    }
}
