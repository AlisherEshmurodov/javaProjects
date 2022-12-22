package com.copyProjects.pdp.onlineFastFood_evos.com.model;

import java.util.Objects;

public class Branch {  // filial

    private int id;
    private String address;
    private String name;

    static int currentId = 1;
    {
        currentId++;
    }

//    public Branch getBranch(int id){
//        return ...
//    }

    public Branch(int id, String address, String name) {
        this.id = id;
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return id == branch.id && Objects.equals(address, branch.address) && Objects.equals(name, branch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Branch.currentId = currentId;
    }
}
