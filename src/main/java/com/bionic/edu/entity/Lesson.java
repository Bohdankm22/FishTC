package com.bionic.edu.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Lesson_id;
    private String Lesson_Name;
    private boolean Lesson_isDeleted;

    public int getLesson_id() {
        return Lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        Lesson_id = lesson_id;
    }

    public String getLesson_Name() {
        return Lesson_Name;
    }

    public void setLesson_Name(String lesson_Name) {
        Lesson_Name = lesson_Name;
    }

    public boolean isLesson_isDeleted() {
        return Lesson_isDeleted;
    }

    public void setLesson_isDeleted(boolean lesson_isDeleted) {
        Lesson_isDeleted = lesson_isDeleted;
    }
}
