package org.code;

import org.code.enums.PassengerType;
import org.code.models.*;
import org.code.service.ActivityService;
import org.code.service.PassengerService;
import org.code.service.TravelAgencyService;
import org.code.service.TravelPackageService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Destinations
        Destination destination1 = new Destination("Destination 1");
        Destination destination2 = new Destination("Destination 2");
        Destination destination3 = new Destination("Destination 3");
        Destination destination4 = new Destination("Destination 4");

        // Activities
        ActivityService activityService = new ActivityService();

        Activity activity1 = activityService.createActivity("Activity 1", "Description 1", 100.0, 8, destination1);
        Activity activity2 = activityService.createActivity("Activity 2", "Description 2", 200.0, 4, destination1);

        Activity activity3 = activityService.createActivity("Activity 3", "Description 3", 50.0, 6, destination2);
        Activity activity4 = activityService.createActivity("Activity 4", "Description 4", 150.0, 3, destination2);

        Activity activity5 = activityService.createActivity("Activity 5", "Description 5", 100.0, 10, destination3);

        Activity activity6 = activityService.createActivity("Activity 6", "Description 6", 100.0, 10, destination4);
        Activity activity7 = activityService.createActivity("Activity 7", "Description 7", 100.0, 10, destination4);


        // Packages
        TravelPackageService travelPackageService = new TravelPackageService();

        TravelPackage package1 = travelPackageService.createPackage("Package 1",
                20,
                List.of(destination1, destination2, destination4)
        );

        TravelPackage package2 = travelPackageService.createPackage("Package 2",
                15,
                List.of(destination1, destination2, destination3)
        );


        // Passengers
        Passenger passenger1 = new Passenger("passenger1", 1, PassengerType.STANDARD, 500.0);
        Passenger passenger2 = new Passenger("passenger2", 2, PassengerType.GOLD, 300.0);
        Passenger passenger3 = new Passenger("passenger3", 3, PassengerType.PREMIUM, 0.0);
        Passenger passenger4 = new Passenger("passenger4", 1, PassengerType.STANDARD, 100.0);
        Passenger passenger5 = new Passenger("passenger5", 2, PassengerType.GOLD, 350.0);
        Passenger passenger6 = new Passenger("passenger6", 3, PassengerType.PREMIUM, 0.0);
        Passenger passenger7 = new Passenger("passenger7", 1, PassengerType.STANDARD, 200.0);
        Passenger passenger8 = new Passenger("passenger8", 2, PassengerType.GOLD, 300.0);
        Passenger passenger9 = new Passenger("passenger9", 3, PassengerType.PREMIUM, 0.0);


        // TravelAgency
        TravelAgencyService travelAgencyService = new TravelAgencyService();
        TravelAgency agency = travelAgencyService.createTravelAgency(List.of(package1));
        travelAgencyService.addTravelPackage(agency, List.of(package2));


        // Note : package1 : Activities : 1,2,3,4,6,7
        // Note : package2 : Activities : 1,2,3,4,5

        package1.addPassenger(passenger1);
        travelPackageService.bookActivity(package1, activity1, passenger1);
        travelPackageService.bookActivity(package1, activity3, passenger1);
        travelPackageService.bookActivity(package1, activity7, passenger1);

        package1.addPassenger(passenger2);
        travelPackageService.bookActivity(package1, activity1, passenger2);
        travelPackageService.bookActivity(package1, activity6, passenger2);
        travelPackageService.bookActivity(package1, activity4, passenger2);

        package1.addPassenger(passenger3);
        travelPackageService.bookActivity(package1, activity1, passenger3);
        travelPackageService.bookActivity(package1, activity2, passenger3);
        travelPackageService.bookActivity(package1, activity3, passenger3);
        travelPackageService.bookActivity(package1, activity4, passenger3);
        travelPackageService.bookActivity(package1, activity5, passenger3);

        // Print itinerary of the travel package
        travelPackageService.printItinerary(package1);

        // Print passenger list of the travel package
        travelPackageService.printPassengerList(package1);

        // Print details of an individual passenger
        PassengerService passengerService = new PassengerService();
        passengerService.printPassengerDetails(passenger2);
        passengerService.printPassengerDetails(passenger1);
        passengerService.printPassengerDetails(passenger3);
    }


}