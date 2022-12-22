package com.mini_OOP_Projects.pdp.coWorking_Booking.com.model;

import java.util.Objects;

public class Room {
    private int id;
    private String name;
    private CoWorking coWorking;
    private int floorNumber;
    private int numberOfPlaces;
    private int priceForPerPlace;
    static int currentId=1;
    {
        currentId++;
    }

    public Room() {
    }

    public Room(int id, String name, CoWorking coWorking, int floorNumber, int numberOfPlaces, int priceForPerPlace) {
        this.id = id;
        this.name = name;
        this.coWorking = coWorking;
        this.floorNumber = floorNumber;
        this.numberOfPlaces = numberOfPlaces;
        this.priceForPerPlace = priceForPerPlace;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coWorking=" + coWorking +
                ", floorNumber=" + floorNumber +
                ", numberOfPlaces=" + numberOfPlaces +
                ", priceForPerPlace=" + priceForPerPlace +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && floorNumber == room.floorNumber && numberOfPlaces == room.numberOfPlaces && priceForPerPlace == room.priceForPerPlace && Objects.equals(name, room.name) && Objects.equals(coWorking, room.coWorking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coWorking, floorNumber, numberOfPlaces, priceForPerPlace);
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

    public CoWorking getCoWorking() {
        return coWorking;
    }

    public void setCoWorking(CoWorking coWorking) {
        this.coWorking = coWorking;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public int getPriceForPerPlace() {
        return priceForPerPlace;
    }

    public void setPriceForPerPlace(int priceForPerPlace) {
        this.priceForPerPlace = priceForPerPlace;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Room.currentId = currentId;
    }
}
