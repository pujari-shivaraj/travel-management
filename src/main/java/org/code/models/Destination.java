package org.code.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Destination {
    private final String name;
    private final List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

}
