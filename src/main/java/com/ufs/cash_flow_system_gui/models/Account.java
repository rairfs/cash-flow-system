package com.ufs.cash_flow_system_gui.models;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private Double balance;
    private Client client;
    private List<Report> transactionHistory;

    public Account() {
    }

    public Account(Client client) {
        SecureRandom secureRandom = new SecureRandom();
        long id = Math.abs(secureRandom.nextLong());

        this.accountNumber = String.format("%06d", id).substring(0, 6);
        this.client = client;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<Report>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Report> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Report> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, client);
    }
}
