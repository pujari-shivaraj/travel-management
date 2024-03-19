package org.code.service;

import org.code.models.TravelAgency;
import org.code.models.TravelPackage;

import java.util.List;

public class TravelAgencyService {

    public TravelAgency createTravelAgency(final List<TravelPackage> travelPackages){
        TravelAgency agency = new TravelAgency();
        addTravelPackage(agency, travelPackages);
        return agency;

    }

    public void addTravelPackage(final TravelAgency travelAgency,
                                 final List<TravelPackage> travelPackages) {
        for (TravelPackage travelPackage : travelPackages) {
            travelAgency.getPackages().add(travelPackage);
        }
    }
}
