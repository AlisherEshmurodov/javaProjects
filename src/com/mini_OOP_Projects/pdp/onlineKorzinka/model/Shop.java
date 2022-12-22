package com.mini_OOP_Projects.pdp.onlineKorzinka.model;

public class Shop {
//    private int id;
    private String address;
    private String name;

    public Shop(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
