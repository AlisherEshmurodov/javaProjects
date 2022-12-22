package com.mini_OOP_Projects.pdp.coWorking_Booking.com.model;

import java.util.Objects;

public class Order {

    private int id;
    private User user;
    private Place place;
    private int sum;
    private String fromDate;
    private String toDate;
    static int currentId = 1;
    {
        currentId++;
    }

    public Order() {
    }

    public Order(int id, User user, Place place, int sum, String fromDate, String toDate) {
        this.id = id;
        this.user = user;
        this.place = place;
        this.sum = sum;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", place=" + place +
                ", sum=" + sum +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && sum == order.sum && Objects.equals(user, order.user) && Objects.equals(place, order.place) && Objects.equals(fromDate, order.fromDate) && Objects.equals(toDate, order.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, place, sum, fromDate, toDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Order.currentId = currentId;
    }
}
