package com.bionic.edu.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Groups_id;
    private String Groups_Number;
    private boolean Groups_isDeleted;
    private int Groups_StartYear;

    @ManyToOne
    @JoinColumn(name="Specialization_id")
    private Specialization specialization;


    @ManyToMany
    @JoinTable(name="STUDENTS_IN_GROUPS")
    private List<Students> studentsInGroups;

    public int getGroups_id() {
        return Groups_id;
    }

    public void setGroups_id(int groups_id) {
        Groups_id = groups_id;
    }

    public String getGroups_Number() {
        return Groups_Number;
    }

    public void setGroups_Number(String groups_Number) {
        Groups_Number = groups_Number;
    }

    public boolean isGroups_isDeleted() {
        return Groups_isDeleted;
    }

    public void setGroups_isDeleted(boolean groups_isDeleted) {
        Groups_isDeleted = groups_isDeleted;
    }

    public int getGroups_StartYear() {
        return Groups_StartYear;
    }

    public void setGroups_StartYear(int groups_StartYear) {
        Groups_StartYear = groups_StartYear;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Students> getStudentsInGroups() {
        return studentsInGroups;
    }

    public void setStudentsInGroups(List<Students> studentsInGroups) {
        this.studentsInGroups = studentsInGroups;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "Groups_id=" + Groups_id +
                ", Groups_Number='" + Groups_Number + '\'' +
                ", Groups_isDeleted=" + Groups_isDeleted +
                ", Groups_StartYear=" + Groups_StartYear +
                ", specialization=" + specialization +
                ", studentsInGroups=" + studentsInGroups +
                '}';
    }
}
