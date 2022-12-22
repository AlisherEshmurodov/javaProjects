package com.mini_OOP_Projects.pdp.coWorking_Booking.com.model;

import java.util.Objects;

public class Place {
    private int id;
    private Room room;
    private int price;
    private int placeNumber;
    private Status status;
    static int currentId = 1;
    {
        currentId++;
    }

    public Place() {
    }

    public Place(int id, Room room, int price, int placeNumber, Status status) {
        this.id = id;
        this.room = room;
        this.price = price;
        this.placeNumber = placeNumber;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", room=" + room +
                ", price=" + price +
                ", placeNumber=" + placeNumber +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id && price == place.price && placeNumber == place.placeNumber && Objects.equals(room, place.room) && status == place.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room, price, placeNumber, status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Place.currentId = currentId;
    }
}
