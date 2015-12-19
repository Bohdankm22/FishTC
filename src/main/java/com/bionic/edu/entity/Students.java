package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Students_id;
    private String Students_Name;
    private boolean Students_isDeleted;
    private String Students_Login;
    private String Students_password;

    public int getStudents_id() {
        return Students_id;
    }

    public void setStudents_id(int students_id) {
        Students_id = students_id;
    }

    public String getStudents_Name() {
        return Students_Name;
    }

    public void setStudents_Name(String students_Name) {
        Students_Name = students_Name;
    }

    public boolean isStudents_isDeleted() {
        return Students_isDeleted;
    }

    public void setStudents_isDeleted(boolean students_isDeleted) {
        Students_isDeleted = students_isDeleted;
    }

    public String getStudents_Login() {
        return Students_Login;
    }

    public void setStudents_Login(String students_Login) {
        Students_Login = students_Login;
    }

    public String getStudents_password() {
        return Students_password;
    }

    public void setStudents_password(String students_password) {
        Students_password = students_password;
    }

    @Override
    public String toString() {
        return "Students{" +
                "Students_id=" + Students_id +
                ", Students_Name='" + Students_Name + '\'' +
                ", Students_isDeleted=" + Students_isDeleted +
                ", Students_Login='" + Students_Login + '\'' +
                ", Students_password='" + Students_password + '\'' +
                '}';
    }
}
