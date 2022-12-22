package com.copyProjects.pdp.onlineFastFood_evos.com.model;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String phoneNumber;
    private Role role;
    private Branch branch;


    static int currentId = 1;
    {
        currentId++;
    }

    public User() {
    }

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User(int id, String name, String phoneNumber, Role role, Branch branch) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.branch = branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(phoneNumber, user.phoneNumber) && role == user.role && Objects.equals(branch, user.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, role, branch);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                ", branch=" + branch +
                '}';
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        User.currentId = currentId;
    }
}
