package com.mini_OOP_Projects.pdp.coWorking_Booking.com.model;

import java.util.Objects;

public class CoWorkingManager {
    private int id;
    private CoWorking coWorking;
    private User user;
    static int currentId = 1;
    {
        currentId++;
    }

    public CoWorkingManager() {
    }

    public CoWorkingManager(int id, CoWorking coWorking, User user) {
        this.id = id;
        this.coWorking = coWorking;
        this.user = user;
    }

    @Override
    public String toString() {
        return "CoWorkingManager{" +
                "id=" + id +
                ", coWorking=" + coWorking +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoWorkingManager that = (CoWorkingManager) o;
        return id == that.id && Objects.equals(coWorking, that.coWorking) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coWorking, user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoWorking getCoWorking() {
        return coWorking;
    }

    public void setCoWorking(CoWorking coWorking) {
        this.coWorking = coWorking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        CoWorkingManager.currentId = currentId;
    }
}
