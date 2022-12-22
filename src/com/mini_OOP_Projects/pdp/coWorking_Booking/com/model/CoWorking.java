package com.mini_OOP_Projects.pdp.coWorking_Booking.com.model;

import java.util.Objects;

public class CoWorking {
    private  int id;
    private String name;
    private String address;
    static int currentId = 1;
    {
        currentId++;
    }

    public CoWorking() {
    }

    public CoWorking(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "CoWorking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoWorking coWorking = (CoWorking) o;
        return id == coWorking.id && Objects.equals(name, coWorking.name) && Objects.equals(address, coWorking.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        CoWorking.currentId = currentId;
    }
}
