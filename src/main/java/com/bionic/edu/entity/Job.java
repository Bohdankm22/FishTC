package com.bionic.edu.entity;

import javax.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Job_id;
    private String Job_Title;
    private String Job_Description;
    private boolean Job_isDeleted;

    @ManyToOne
    @JoinColumn(name="Lesson_id")
    private Lesson lesson;

    public int getJob_id() {
        return Job_id;
    }

    public void setJob_id(int job_id) {
        Job_id = job_id;
    }

    public String getJob_Title() {
        return Job_Title;
    }

    public void setJob_Title(String job_Title) {
        Job_Title = job_Title;
    }

    public String getJob_Description() {
        return Job_Description;
    }

    public void setJob_Description(String job_Description) {
        Job_Description = job_Description;
    }

    public boolean isJob_isDeleted() {
        return Job_isDeleted;
    }

    public void setJob_isDeleted(boolean job_isDeleted) {
        Job_isDeleted = job_isDeleted;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
