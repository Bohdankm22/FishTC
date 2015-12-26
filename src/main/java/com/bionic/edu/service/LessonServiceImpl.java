package com.bionic.edu.service;

import com.bionic.edu.dao.LessonDao;
import com.bionic.edu.entity.Lesson;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LessonServiceImpl implements LessonService {

    @Inject
    private LessonDao lessonDao;

    @Override
    @Transactional
    public void save(Lesson lesson){
        lessonDao.save(lesson);
    }

    @Override
    public List<Lesson> getAll() {
        return lessonDao.getAll();
    }

    @Override
    public Lesson findById(int n) {
        return lessonDao.findById(n);
    }

    @Override
    @Transactional
    public void update(Lesson lesson) {
        lessonDao.update(lesson);
    }
}
