package ru.job4j.oop.inheritance;

public class Engineer extends Profession {
    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Project design(String[] userStories) {
        return null;
    }

    public void administrate(Project proj) {
    }
}
