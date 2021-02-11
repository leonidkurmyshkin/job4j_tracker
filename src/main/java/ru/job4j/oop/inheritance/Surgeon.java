package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {
    private String speciality;

    public Surgeon(String name, String surname, String education, String birthday,
                   String speciality) {
        super(name, surname, education, birthday);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void performSurgery(Pacient pacient, Operation operation) {
    }
}
