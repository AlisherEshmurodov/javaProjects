package com.mini_OOP_Projects.pdp.onlineKorzinka.model;

import java.math.BigDecimal;

public class Product {
    private String name;
    private Measurement measure;
    private BigDecimal price;

    public Product(String name, Measurement measure, BigDecimal price) {
        this.name = name;
        this.measure = measure;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measurement getMeasure() {
        return measure;
    }

    public void setMeasure(Measurement measure) {
        this.measure = measure;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
