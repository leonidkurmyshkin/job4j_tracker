package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных "Пользователь".
 * @author Leonid Kurmyshkin
 * @version 1.0
 */
public class User {

    /**
     * Поле хранит номер паспорта пользователя.
     */
    private String passport;

    /**
     * Поле хранит ФИО пользователя.
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Пользователи равны, если равны номера их паспортов.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Хэшкод вычисляется по номеру паспорта.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}