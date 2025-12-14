package com.ufs.cash_flow_system_gui.models;

import java.util.Objects;

public class Client {

    private String name;
    private String birthDate;
    private Account account;

    public Client() {
    }

    public Client(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.account = new Account(this);
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

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", account=" + account +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(account, client.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, account);
    }
}
