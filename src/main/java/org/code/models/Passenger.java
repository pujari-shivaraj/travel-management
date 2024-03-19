package org.code.models;

import lombok.Getter;
import org.code.enums.PassengerType;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Passenger {
    private final String name;
    private final int passengerNumber;
    private final PassengerType type;
    private double balance;
    private final List<ActivityBooking> activityBookings;

    public Passenger(String name, int passengerNumber, PassengerType type, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.balance = balance;
        this.activityBookings = new ArrayList<>();
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }


}
