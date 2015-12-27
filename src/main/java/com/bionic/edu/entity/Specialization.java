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
    private boolean Specialization_isDeleted;

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

    public boolean isSpecialization_isDeleted() {
        return Specialization_isDeleted;
    }

    public void setSpecialization_isDeleted(boolean specialization_isDeleted) {
        Specialization_isDeleted = specialization_isDeleted;
    }
}
