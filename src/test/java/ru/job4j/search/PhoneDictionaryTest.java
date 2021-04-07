package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Oleg", "Skrypka", "531872", "Kazan")
        );
        phones.add(
                new Person("Ivan", "Petrov", "534870", "Moskow")
        );
        var expected = List.of(
                new Person("Petr", "Arsentev", "534872", "Bryansk"),
                new Person("Ivan", "Petrov", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
        assertThat(persons.get(1).getSurname(), is("Petrov"));
    }
}