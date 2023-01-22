package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса:
 * добавление, удаление пользователей, поиск пользователя
 * по заданным параметрам, добавление счетов, операции
 * по переводу денег
 * @author Irina Sh
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными
     * к ним счетами
     * Хранение осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему, если его нет в системе
     * @param user пользователь, которого необходимо добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить пользователя из системы.
     * @param passport номер паспорта, по которому определяется пользователь
     * для удаления
     * @return возвращает true если пользователь был удален и false если не был
     */
    public boolean deleteUser(String passport) {
            return users.remove(new User(passport, null)) != null;
    }

    /**
     * Метод добавляет новый счет к пользователю
     * @param passport номер паспорта, по которому определяется если такой пользователь
     * @param account новый счет, который проходит проверку на наличие у пользователя в
     * списке существующих счетов
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту
     * @param passport номер паспорта пользователя
     * @return возращает пользователя если он был найден и null если нет
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по паспорту и реквизитам счета
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return возвращает счет, если он был найден, либо null если нет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счета
     * на другой
     * @param srcPassport паспорт пользователя, со счета которго осуществляется перевод
     * @param srcRequisite реквизиты счета, с которого осуществляется перевод
     * @param destPassport паспорт пользователя, которому перевдят деньги
     * @param destRequisite реквизиты счета, на который переводят деньги
     * @param amount сумма перевода
     * @return возращает true если перевод прошел успешно, false если нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод для получения счетов пользователя
     * @param user пользователь счетов
     * @return возвращает счета пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
