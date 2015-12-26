package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Specialization_id;
    private String Specialization_Name;
    private String Specialization_ShortName;
    private boolean Teacher_isDeleted;

    public int getSpecialization_id() {
        return Specialization_id;
    }

    public void setSpecialization_id(int specialization_id) {
        Specialization_id = specialization_id;
    }

    public String getSpecialization_Name() {
        return Specialization_Name;
    }

    public void setSpecialization_Name(String specialization_Name) {
        Specialization_Name = specialization_Name;
    }

    public String getSpecialization_ShortName() {
        return Specialization_ShortName;
    }

    public void setSpecialization_ShortName(String specialization_ShortName) {
        Specialization_ShortName = specialization_ShortName;
    }

    public boolean isTeacher_isDeleted() {
        return Teacher_isDeleted;
    }

    public void setTeacher_isDeleted(boolean teacher_isDeleted) {
        Teacher_isDeleted = teacher_isDeleted;
    }
}
