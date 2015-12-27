package com.bionic.edu.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Lesson_id;
    private String Lesson_Name;
    private boolean Lesson_isDeleted;

    @OneToMany(mappedBy="lesson")
    private List<Job> listOfJobs;

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

    public List<Job> getListOfJobs() {
        return listOfJobs;
    }

    public void setListOfJobs(List<Job> listOfJobs) {
        this.listOfJobs = listOfJobs;
    }
}
