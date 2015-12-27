package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Groups_id;
    private String Groups_Number;
    private boolean Groups_isDeleted;
    private int Groups_StartYear;

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
}
