package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student aStudent = new Student();
        aStudent.setFullName("Alekseev Ivan Petrovich ");
        aStudent.setGroupNumber("1101");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        aStudent.setAdmissionDate(LocalDate.parse("21/02/2020", formatter));
        System.out.println("ФИО: " + aStudent.getFullName());
        System.out.println("Группа №: " + aStudent.getGroupNumber());
        System.out.println("Дата поступления: "
                + aStudent.getAdmissionDate().format(formatter));
    }
}
