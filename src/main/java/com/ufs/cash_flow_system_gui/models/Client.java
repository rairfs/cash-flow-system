package com.ufs.cash_flow_system_gui.models;

public class Client {

    private String name;
    private String birthDate;
    private Account account;

    public Client() {
    }

    public Client(String name, String birthDate, Account account) {
        this.name = name;
        this.birthDate = birthDate;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
