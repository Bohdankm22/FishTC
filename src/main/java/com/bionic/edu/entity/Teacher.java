package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Teacher_id;
    private String Teacher_Name;
    private String Teacher_Surname;
    private boolean Teacher_isDeleted;

    public int getTeacher_id() {
        return Teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        Teacher_id = teacher_id;
    }

    public String getTeacher_Name() {
        return Teacher_Name;
    }

    public void setTeacher_Name(String teacher_Name) {
        Teacher_Name = teacher_Name;
    }

    public String getTeacher_Surname() {
        return Teacher_Surname;
    }

    public void setTeacher_Surname(String teacher_Surname) {
        Teacher_Surname = teacher_Surname;
    }

    public boolean isTeacher_isDeleted() {
        return Teacher_isDeleted;
    }

    public void setTeacher_isDeleted(boolean teacher_isDeleted) {
        Teacher_isDeleted = teacher_isDeleted;
    }
}
