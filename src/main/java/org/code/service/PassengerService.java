package org.code.service;

import org.code.enums.PassengerType;
import org.code.models.Activity;
import org.code.models.ActivityBooking;
import org.code.models.Passenger;

import java.util.List;

public class PassengerService {

    public void updateBalance(final Passenger passenger, final double balance) {
        passenger.setBalance(balance);
    }

    public void addActivityBooking(final Passenger passenger, ActivityBooking activityBooking) {
        passenger.getActivityBookings().add(activityBooking);
    }

    // Method to handle booking costs based on passenger type
    public void bookActivity(final Passenger passenger, final Activity activity) {
        switch (passenger.getType()) {
            case STANDARD -> {
                if (passenger.getBalance() >= activity.getCost()) {
                    this.updateBalance(passenger, passenger.getBalance() - activity.getCost());
                    System.out.println("Activity: " + activity.getName() +
                            " at destination: " + activity.getDestination().getName() +
                            " is booked by passenger name: " + passenger.getName() +
                            " Remaining balance : " + passenger.getBalance());
                    this.addActivityBooking(passenger, new ActivityBooking(activity, activity.getCost()));
                } else {
                    System.out.println("Insufficient balance for passenger " + passenger.getName() + " to book activity " + activity.getName());
                }
            }
            case GOLD -> {
                double discountedCost = activity.getCost() * 0.9; // 10% discount
                if (passenger.getBalance() >= discountedCost) {
                    this.updateBalance(passenger, discountedCost);

                    System.out.println("Activity: " + activity.getName() +
                            " at destination: " + activity.getDestination().getName() +
                            " is booked by passenger name: " + passenger.getName() +
                            " Remaining balance : " + passenger.getBalance());
                    this.addActivityBooking(passenger, new ActivityBooking(activity, discountedCost));
                } else {
                    System.out.println("Insufficient balance for passenger " + passenger.getName() + " to book activity " + activity.getName());
                }
            }
            case PREMIUM -> {
                // No need to check balance for PREMIUM passenger as they can book for free
                System.out.println("Activity: " + activity.getName() +
                        " at destination: " + activity.getDestination().getName() +
                        " is booked by passenger name: " + passenger.getName());
                this.addActivityBooking(passenger, new ActivityBooking(activity, 0));
            }
        }
    }

    // Method to print the details of an individual passenger
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());

        if (passenger.getType() == PassengerType.STANDARD || passenger.getType() == PassengerType.GOLD) {
            System.out.println("Balance: $" + passenger.getBalance());
        }

        List<ActivityBooking> activityBookings = passenger.getActivityBookings();
        if (!activityBookings.isEmpty()) {
            System.out.println("Activities Booked:");
            for (ActivityBooking booking : activityBookings) {
                Activity activity = booking.getActivity();
                System.out.println("- Activity: " + activity.getName());
                System.out.println("  Destination: " + activity.getDestination().getName());
                System.out.println("  Price Paid: $" + booking.getPrice());
            }
        } else {
            System.out.println("No activities booked.");
        }
    }
}
