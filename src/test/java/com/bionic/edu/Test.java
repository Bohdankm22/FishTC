package com.bionic.edu;

import com.bionic.edu.entity.Students;
import com.bionic.edu.service.StudentsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;


public class Test {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private static StudentsService studentsService = context.getBean(StudentsService.class);
    private static final List<String> studNames = Arrays.asList("Bohdan_Ivanov", "Ivan_Bozhenko", "Petro_Sagaydak", "Vasily_Rybka", "Evgeny_Ozerny");

    public static void main(String[] args) {
        printAllStudentsAndGroups();
    }

    public Students getStudByLogin(String login, String pass) {
        return studentsService.findByLoginPass(login, pass);
    }

    public void saveStudent(String name, String login, String pass) {
        Students student = new Students();
        student.setStudents_isDeleted(false);
        student.setStudents_Login(login);
        student.setStudents_Name(name);
        student.setStudents_password(pass);
        studentsService.save(student);
    }

    public static void saveStudents(List<String> studentsNames) {
        for (String studName : studentsNames) {
            Test test1 = new Test();
            test1.saveStudent(studName, studName, "1111");
            System.out.println(studentsService.getAll());
        }
    }


    private static void printAllStudentsAndGroups() {
        System.out.println(studentsService.getAll());
    }
}
