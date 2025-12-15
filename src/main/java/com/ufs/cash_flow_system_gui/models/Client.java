package com.ufs.cash_flow_system_gui.models;

import java.time.LocalDate;
import java.util.Objects;

public class Client {

    private String name;
    private LocalDate birthDate;
    private Account account;

    public Client() {
    }

    public Client(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.account = new Account(this);
    }

    public Client(String name, LocalDate birthDate, Account account) {
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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
                ", birthDate='" + birthDate.toString() + '\'' +
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
