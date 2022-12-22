package com.mini_OOP_Projects.pdp.onlineKorzinka.model;

import java.math.BigDecimal;

public class User {
    private String name;
    private String login;
    private BigDecimal balance;

    public User(String name, String login, BigDecimal balance) {
        this.name = name;
        this.login = login;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
