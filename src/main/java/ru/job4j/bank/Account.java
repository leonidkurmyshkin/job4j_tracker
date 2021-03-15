package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных "Банковский счёт".
 * @author Leonid Kurmyshkin
 * @version 1.0
 */
public class Account {
    /**
     * Поле хранит реквизиты счёта.
     */
    private String requisite;

    /**
     * Поле хранит баланс счёта
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Счета равны, если равны их поля requisite.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Хэшкод вычисляется по значению поля requisite.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}