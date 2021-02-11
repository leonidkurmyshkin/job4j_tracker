package ru.job4j.oop.inheritance;

public class Doctor extends Profession {
    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Diagnosis check(Pacient pacient) {
        return null;
    }

    public Recipe heal(Pacient pacient) {
        return null;
    }
}
