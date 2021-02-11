package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {
    private String progLang;

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
