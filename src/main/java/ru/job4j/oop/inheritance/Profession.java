package ru.job4j.oop.inheritance;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public String getName() {
        return name;
    }

    private String getSurname() {
        return surname;
    }

    private String getEducation() {
        return education;
    }

    private String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
