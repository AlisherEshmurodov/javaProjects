package com.mini_OOP_Projects.pdp.onlineKorzinka.model;

import java.math.BigDecimal;

public class Order {
    private User user;
    private BigDecimal totalScore;
    private Shop shop;

    public Order(User user, BigDecimal totalScore, Shop shop) {
        this.user = user;
        this.totalScore = totalScore;
        this.shop = shop;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
