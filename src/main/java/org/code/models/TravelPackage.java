package org.code.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class TravelPackage {
    private final String name;
    private final int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;
    private Map<Activity, List<Passenger>> bookings;
    public TravelPackage(final String name,
                         final int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.bookings = new HashMap<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }


}
