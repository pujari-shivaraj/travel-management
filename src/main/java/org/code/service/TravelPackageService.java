package org.code.service;

import org.code.models.Activity;
import org.code.models.Destination;
import org.code.models.Passenger;
import org.code.models.TravelPackage;

import java.util.ArrayList;
import java.util.List;

public class TravelPackageService {

    private final PassengerService passengerService;

    private final ActivityService activityService;

    public TravelPackageService() {
        this.passengerService = new PassengerService();
        this.activityService = new ActivityService();
    }

    public TravelPackage createPackage(final String packageName,
                                       final int passengerCapacity,
                                       List<Destination> destinations) {
        TravelPackage package1 = new TravelPackage(packageName, passengerCapacity);
        for (Destination destination : destinations) {
            package1.addDestination(destination);
        }
        return package1;
    }

    public void bookActivity(final TravelPackage travelPackage,
                             final Activity activity,
                             final Passenger passenger) {
        // Check if activity is fully booked
        if (activityService.isAvailableToBook(activity)) {
            passengerService.bookActivity(passenger,activity);
            activityService.book(activity);
            if (travelPackage.getBookings().containsKey(activity)) {
                List<Passenger> activityBookings = travelPackage.getBookings().get(activity);
                activityBookings.add(passenger);
            } else {
                List<Passenger> activityBookings = new ArrayList<>();
                activityBookings.add(passenger);
                travelPackage.getBookings().put(activity, activityBookings);
            }
        } else {
            System.out.println("Activity " + activity.getName() + " at destination " + activity.getDestination().getName() + " is fully booked.");
        }
    }

    // Method to print the passenger list of a travel package
    public void printPassengerList(TravelPackage travelPackage) {
        System.out.println("Travel Package: " + travelPackage.getName());
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
        System.out.println("Passenger List:");

        for (Passenger passenger : travelPackage.getPassengers()) {
            System.out.println("Name: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }

    // Method to print the itinerary of a travel package
    public void printItinerary(TravelPackage travelPackage) {
        System.out.println("Travel Package: " + travelPackage.getName());
        System.out.println("Itinerary:");

        List<Destination> destinations = travelPackage.getItinerary();
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            List<Activity> activities = destination.getActivities();
            System.out.println("Activities:");

            for (Activity activity : activities) {
                System.out.println("Name: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Cost: $" + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
                System.out.println();
            }
        }
    }
}
