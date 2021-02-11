package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {
    private String progLang;

    public Programmer(String name, String surname, String education, String birthday,
                      String progLang) {
        super(name, surname, education, birthday);
        this.progLang = progLang;
    }

    public String getProgLang() {
        return progLang;
    }

    public void setProgLang(String progLang) {
        this.progLang = progLang;
    }

    public Source writeCode(Project project) {
        return null;
    }

    public UnitTest writeTest(Source source) {
        return null;
    }
}
