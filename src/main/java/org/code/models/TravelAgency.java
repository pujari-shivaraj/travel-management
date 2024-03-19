package org.code.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TravelAgency {
    private final List<TravelPackage> packages;

    public TravelAgency() {
        this.packages = new ArrayList<>();
    }
}