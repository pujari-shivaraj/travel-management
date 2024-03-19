package org.code.models;


public class Activity {


    private String name;
    private String description;
    private double cost;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public int getBooked() {
        return booked;
    }

    private int capacity;
    private Destination destination;

    private int booked;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.booked = 0;
    }

    public void setBooked(int i){
        this.booked=i;
    }





}
