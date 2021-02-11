package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {
    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void performSurgery(Pacient pacient, Operation operation) {

    }


}
