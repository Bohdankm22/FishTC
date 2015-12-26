package com.bionic.edu.bean;


import com.bionic.edu.entity.Students;
import com.bionic.edu.service.StudentsService;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Scope("session")
public class AdminUniversityBean {

    @Inject
    private StudentsService studentsService;

    private List<Students> allStudents = null;

    private Students newAddedStudent = null;

    private static AdminUniversityBean admin = new AdminUniversityBean();

    private static boolean isAdmin = false;

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
            studentsService.save(newAddedStudent);
            return "success";
        }
    }
}
