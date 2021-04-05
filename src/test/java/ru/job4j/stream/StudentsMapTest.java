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
                new Student("Surname1", 70),
                new Student("Surname4", 40),
                new Student("Surname5", 50),
                new Student("Surname1", 50),
                new Student("Surname5", 90)
        );
        Map<String, Student> rsl = StudentsMap.listToMap(students);
        Map<String, Student> expected = Map.of(
                "Surname1", new Student("Surname1", 70),
                "Surname4", new Student("Surname4", 40),
                "Surname5", new Student("Surname5", 90)
        );
        assertThat(rsl, is(expected));
    }
}