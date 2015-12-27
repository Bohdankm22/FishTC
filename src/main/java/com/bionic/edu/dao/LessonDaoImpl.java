package com.bionic.edu.dao;

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

    @Override
    public List<Lesson> getStudentLessons(int id) {
        String txt = "select Lesson_id, Lesson_Name, Lesson_isdeleted" +
                " FROM STUDENTS, GROUPS, STUDENTS_IN_GROUPS, SPECIALIZATION, SPEC_LESSON, LESSON" +
                " WHERE STUDENTS.STUDENTS_ID=STUDENTS_IN_GROUPS.STUDENTSINGROUPS_STUDENTS_ID" +
                " AND STUDENTS_IN_GROUPS.STUDENTSINGROUPS_GROUPS_ID=GROUPS.GROUPS_ID" +
                " AND SPECIALIZATION.SPECIALIZATION_ID=GROUPS.SPECIALIZATION_ID" +
                " AND SPECIALIZATION.SPECIALIZATION_ID=SPEC_LESSON.SPECLESSON_SPECIALIZATION_ID" +
                " AND SPEC_LESSON.SPECLESSON_LESSON_ID=LESSON.LESSON_ID" +
                " AND STUDENTS.STUDENTS_ID=" + id + "";
        Query query = em.createNativeQuery(txt);
        List<Object[]> list = query.getResultList();
        List<Lesson> result = new ArrayList<>();
        for (Object[] o : list) {
            Lesson lesson = new Lesson();
            lesson.setLesson_id(Integer.parseInt(((BigDecimal) o[0]).toString()));
            lesson.setLesson_Name((String) o[1]);
            boolean res = Integer.parseInt(((BigDecimal) o[2]).toString()) != 0;
            lesson.setLesson_isDeleted(res);
            result.add(lesson);
        }
        return result;
    }
}
