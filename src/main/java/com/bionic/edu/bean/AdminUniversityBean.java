package com.bionic.edu.bean;


import com.bionic.edu.entity.Groups;
import com.bionic.edu.entity.Students;
import com.bionic.edu.service.GroupService;
import com.bionic.edu.service.StudentsService;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
@Scope("session")
public class AdminUniversityBean {

    @Inject
    private StudentsService studentsService;

    @Inject
    private GroupService groupService;

    private List<Students> allStudents = null;

    private Students newAddedStudent = null;

    private Groups newAddedGroups = null;

    private static AdminUniversityBean admin = new AdminUniversityBean();

    private static boolean isAdmin = false;

    private List<Groups> groups = null;

    private Groups selectedGroup = null;

    private AdminUniversityBean() {

    }

    public static AdminUniversityBean getAdmin() {
        return admin;
    }

    public static boolean isAdmin() {
        return isAdmin;
    }

    public static void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String showAllStudents() {
        return "allStudents";
    }

    public void refreshListOfStudents() {
        allStudents = studentsService.getAll();
    }

    public List<Students> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List<Students> allStudents) {
        this.allStudents = allStudents;
    }

    public static void setAdmin(AdminUniversityBean admin) {
        AdminUniversityBean.admin = admin;
    }

    public void onRowEdit(RowEditEvent event) {
        Students i = (Students) event.getObject();
        if (studentsService.findById(i.getStudents_id()) != null) {
            studentsService.update(i);
        }
        FacesMessage msg = new FacesMessage("Customer edited", i.getStudents_Name());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Students) event.getObject()).getStudents_Name());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String addStudentPage() {
        return "addStudentPage";
    }

    public Students getNewAddedStudent() {
        return newAddedStudent;
    }

    public void setNewAddedStudent(Students newAddedStudent) {
        this.newAddedStudent = newAddedStudent;
    }

    public void createNewStudent() {
        setNewAddedStudent(new Students());
    }

    public String saveNewStudent() {
        if (studentsService.isLoginExist(newAddedStudent.getStudents_Login())) {
            return "loginExists";
        }
        else {
            newAddedStudent.setStudents_isDeleted(false);
            newAddedStudent.setStudentsInGroups(Arrays.asList(groupService.findById(1)));
            studentsService.save(newAddedStudent);
            return "success";
        }
    }

    public String addGroupPage() {
        return "addGroupPage";
    }

    public void createNewGroup() {
        setNewAddedGroups(new Groups());
    }

    public Groups getNewAddedGroups() {
        return newAddedGroups;
    }

    public void setNewAddedGroups(Groups newAddedGroups) {
        this.newAddedGroups = newAddedGroups;
    }

    public String saveNewGroup() {
        if (groupService.isGroupNameExists(newAddedGroups.getGroups_Number())) {
            return "groupNameExists";
        }
        else {
            newAddedGroups.setGroups_isDeleted(false);
            groupService.save(newAddedGroups);
            return "success";
        }
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }

    public Groups getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(Groups selectedGroup) {
        this.selectedGroup = selectedGroup;
    }
}
