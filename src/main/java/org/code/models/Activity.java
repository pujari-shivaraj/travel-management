package org.code.models;

import lombok.Getter;

@Getter
public class Activity {
    private final String name;
    private final String description;
    private final double cost;
    private final int capacity;
    private final Destination destination;
    private int booked;

    public Activity(final String name,
                    final String description,
                    final double cost,
                    final int capacity,
                    final Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.booked = 0;
    }

    public void book() {
        if (booked < capacity) {
            booked++;
        }
    }

    public boolean isAvailableToBook() {
        return this.booked < this.capacity;
    }
}
