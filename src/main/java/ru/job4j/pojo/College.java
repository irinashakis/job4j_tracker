package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup(1);
        student.setDate(new Date());
        System.out.println("Student " + student.getFio() + " is studying in a group №" + student.getGroup() + " since " + student.getDate());
    }
}
