package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы
 * @author Leonid Kurmyshkin
 * @version 1.0
 */
public class BankService {

    /**
     * Клиенты банковской системы хранятся в словаре.
     * В качестве ключа используется пользователь,
     * значением является список счетов.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в словарь, назначая ему пустой список счетов.
     * @param user добавляемый пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет счет в список счетов пользователя, идентифицированного по номеру паспорта.
     * @param passport номер паспорта пользователя.
     * @param account добавляемый счёт.
     */
    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> accounts = users.get(foundUser);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру его паспорта.
     * @param passport номер паспорта пользователя.
     * @return возвращает найденного пользователя или null, если пользователя найти не удалось.
     */
    public User findByPassport(String passport) {
        User foundUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                foundUser = user;
                break;
            }
        }
        return foundUser;
    }

    /**
     * Метод ищет счёт по номеру паспорта и реквизитам счёта
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счёта
     * @return возвращает найденный счёт или null, если счёт не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account foundAccount = null;
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            for (Account tmpAccount : users.get(foundUser)) {
                if (requisite.equals(tmpAccount.getRequisite())) {
                    foundAccount = tmpAccount;
                    break;
                }
            }
        }
        return foundAccount;
    }

    /**
     * Метод переводит деньги с одного счёта на другой
     * @param srcPassport номер паспорта пользователя, со счёта которого переводятся деньги.
     * @param srcRequisite реквизиты счёта, с которого снимаются деньги.
     * @param destPassport номер паспорта пользователя, которому переводятся деньги.
     * @param destRequisite реквизиты счёта, куда поступают деньги.
     * @param amount сумма перевода.
     * @return возвращает true в случае успешного перевода, или false в противном случае.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean isSuccess = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            isSuccess = true;
        }
        return isSuccess;
    }
}
