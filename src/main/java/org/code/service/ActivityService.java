package org.code.service;

import org.code.models.Activity;
import org.code.models.Destination;

public class ActivityService {

    private final DestinationService destinationService;

    public ActivityService() {
        this.destinationService = new DestinationService();
    }

    public Activity createActivity(final String name,
                                   final String description,
                                   final double cost,
                                   final int capacity,
                                   final Destination destination){
        Activity activity = new Activity(name, description, cost, capacity, destination);
        destinationService.addActivity(destination,activity);
        return activity;
    }

    public void book(final Activity activity) {
        if (activity.getBooked() < activity.getCapacity()) {
            activity.setBooked(activity.getBooked() + 1);
        }
    }



    public boolean isAvailableToBook(final Activity activity) {
        return activity.getBooked() < activity.getCapacity();
    }
}
