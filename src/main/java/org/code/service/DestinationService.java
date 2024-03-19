package org.code.service;

import org.code.models.Activity;
import org.code.models.Destination;

import java.util.ArrayList;

public class DestinationService {

    public Destination createDestination(String name) {
        return new Destination(name);
    }

    public void addActivity(final Destination destination, final Activity activity) {
        destination.getActivities().add(activity);
    }
}
