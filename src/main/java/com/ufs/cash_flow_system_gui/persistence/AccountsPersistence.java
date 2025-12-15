package com.ufs.cash_flow_system_gui.persistence;

import com.ufs.cash_flow_system_gui.models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountsPersistence {

    private static List<Account> accounts = new ArrayList<>();

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(List<Account> accounts) {
        AccountsPersistence.accounts = accounts;
    }

    public static Account getAccountByClientName(String name) {
        for (Account account : accounts) {
            if (account.getClient().getName().equals(name)) {
                return account;
            }
        }
        return null;
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static void updateAccount(Account account) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber().equals(account.getAccountNumber())) {
                accounts.set(i, account);
                return;
            }
        }
    }

    public static void deleteAccount(String accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

}
