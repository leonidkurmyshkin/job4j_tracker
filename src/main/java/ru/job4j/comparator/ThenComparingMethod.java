package ru.job4j.comparator;

import java.util.Comparator;
import java.util.Objects;

public class ThenComparingMethod {

    public static class User implements Comparable<User> {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(User u) {
            return thenComparing().compare(this, u);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

    }

    public static Comparator<User> thenComparing() {
        return ascByName().thenComparing(descByAge());
    }

    public static Comparator<User> ascByName() {
        return new Comparator<>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

    public static Comparator<User> descByAge() {
        return new Comparator<>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.getAge(), o1.getAge());
            }
        };
    }
}
