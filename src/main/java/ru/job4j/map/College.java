package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Student rsl = null;
        for (var s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = s;
                break;
            }
        }
        return Optional.ofNullable(rsl);
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Subject rsl = null;
        var s = findByAccount(account);
        if (s.isPresent()) {
            for (var subj : students.get(s.get())) {
                if (name.equals(subj.getName())) {
                    rsl = subj;
                    break;
                }
            }
        }
        return Optional.ofNullable(rsl);
    }
}