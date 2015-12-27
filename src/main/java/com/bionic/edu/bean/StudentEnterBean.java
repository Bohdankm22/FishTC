package com.bionic.edu.bean;

import com.bionic.edu.entity.Lesson;
import com.bionic.edu.entity.Students;
import com.bionic.edu.service.LessonService;
import com.bionic.edu.service.StudentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Scope("session")
public class StudentEnterBean {
    private String login = null;
    private String pass = null;
    private Students studentsPers = null;
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    private List<Lesson> studentLessonsList = null;


//    private static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//    private static StudentsService studentsService = context.getBean(StudentsService.class);
    @Inject
    private StudentsService studentsService;

    @Inject
    private LessonService lessonService;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String findStudent() {
        if (login.equals(ADMIN_LOGIN) && pass.equals(ADMIN_PASSWORD)) {
            AdminUniversityBean.setAdmin(true);
            return "adminUniversityPage";
        }
        else {
            studentsPers = studentsService.findByLoginPass(login, pass);
            if (studentsPers != null) {
                return "studentPage";
            } else {
                return "error403";
            }
        }
    }

    public Students getStudentsPers() {
        return studentsPers;
    }

    public void setStudentsPers(Students studentsPers) {
        this.studentsPers = studentsPers;
    }

    public void studentNull(){
        studentsPers = null;
    }

    public void backToLoginPage() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("studentEnter.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshListOfLessons() {
        if (studentsPers != null) {
            studentLessonsList = lessonService.getStudentLessons(login);
        }
    }
}
