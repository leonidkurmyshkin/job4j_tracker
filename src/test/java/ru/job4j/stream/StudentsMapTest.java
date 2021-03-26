package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentsMapTest {
    @Test
    public void listToMap() {
        List<Student> students = List.of(
                new Student(70, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(50, "Surname1"),
                new Student(90, "Surname5")
        );
        Map<String, Student> rsl = StudentsMap.listToMap(students);
        Map<String, Student> expected = Map.of(
                "Surname1", new Student(70, "Surname1"),
                "Surname4", new Student(40, "Surname4"),
                "Surname5", new Student(90, "Surname5")
        );
        assertThat(rsl, is(expected));
    }
}