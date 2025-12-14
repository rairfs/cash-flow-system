package com.ufs.cash_flow_system_gui.services;

import com.ufs.cash_flow_system_gui.models.Account;
import com.ufs.cash_flow_system_gui.models.Client;
import com.ufs.cash_flow_system_gui.models.Report;
import com.ufs.cash_flow_system_gui.persistence.AccountsPersistence;

import java.util.List;

public class AccountService {

    public AccountService() {
    }

    public Account getAccountByName(String clientName) {
        return AccountsPersistence.getAccountByClientName(clientName);
    }

    public void createAccount(Client client) {
        Account account = new Account(client);
        AccountsPersistence.addAccount(account);
    }

    public void updateAccount(Account account) {
        AccountsPersistence.updateAccount(account);
    }

    public void deleteAccount(String accountNumber) {
        AccountsPersistence.deleteAccount(accountNumber);
    }

    public Double getAccountBalance(String clientName) {
        Account account = AccountsPersistence.getAccountByClientName(clientName);
        if (account != null) {
            return account.getBalance();
        }
        return null;
    }

    public Double getAccountBalance(Client client) {
        Account account = client.getAccount();
        if (account != null) {
            return account.getBalance();
        }
        return null;
    }

    public void deposit(Account account, Double amount) {
        Double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);

        Report report = new Report(amount);
        account.getTransactionHistory().add(report);

        AccountsPersistence.updateAccount(account);
    }

    public boolean withdraw(Account account, Double amount) {
        if (account.getBalance() >= amount) {
            Double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);

            Report report = new Report(-amount);
            account.getTransactionHistory().add(report);

            AccountsPersistence.updateAccount(account);
            return true;
        }
        return false;
    }

    public List<Report> getTransactionHistory(Account account) {
        return account.getTransactionHistory();
    }
}
