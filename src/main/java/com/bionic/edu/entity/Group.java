package com.bionic.edu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Group_id;
    private String Group_Number;
    private boolean Group_isDeleted;

    public int getGroup_id() {
        return Group_id;
    }

    public void setGroup_id(int group_id) {
        Group_id = group_id;
    }

    public String getGroup_Number() {
        return Group_Number;
    }

    public void setGroup_Number(String group_Number) {
        Group_Number = group_Number;
    }

    public boolean isGroup_isDeleted() {
        return Group_isDeleted;
    }

    public void setGroup_isDeleted(boolean group_isDeleted) {
        Group_isDeleted = group_isDeleted;
    }
}
