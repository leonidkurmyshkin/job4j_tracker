package ru.job4j.bank;

import java.util.*;

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
        var foundUser = findByPassport(passport);
        if (foundUser.isPresent()) {
            List<Account> accounts = users.get(foundUser.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счёт по номеру паспорта и реквизитам счёта
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счёта
     * @return возвращает найденный счёт или null, если счёт не найден.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport)
                .stream()
                .flatMap(user -> users.get(user).stream())
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst();
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
        var isSuccess = false;
        var srcAccount = findByRequisite(srcPassport, srcRequisite);
        var destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            isSuccess = true;
        }
        return isSuccess;
    }
}
