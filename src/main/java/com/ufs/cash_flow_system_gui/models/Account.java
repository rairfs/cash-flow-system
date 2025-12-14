package com.ufs.cash_flow_system_gui.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private Double balance;
    private Client client;
    private List<Report> transactionHistory;

    public Account() {
    }

    public Account(String accountNumber, Client client) {
        this.accountNumber = accountNumber;
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
}
