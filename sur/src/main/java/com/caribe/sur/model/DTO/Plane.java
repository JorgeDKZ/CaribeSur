package com.caribe.sur.model.DTO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.caribe.sur.model.Enumerators.Sites;
import com.caribe.sur.model.Enumerators.SizeOfPlane;

public class Plane {
    //ATRIBUTES
    //Places of the plane X = Long of the plane, Y = Place in the both sites
    private int[][] planeSeats;

    //Site where the plane starts
    private Sites siteStart;
    //Site where the plane going to end
    private Sites siteEnd;
    
    //All seats of the plane
    private int allSeats;
    //Available seats of the plane
    private int availableSeats;

    //Default price of the plane
    private float price;
    private float priceSelecterSeat;

    //This date is the date when the plane will take off
    private LocalDate dateOfFlight;

    //CONSTRUCTOR
    public Plane(SizeOfPlane size, Sites siteStart, Sites siteEnd, float price, float priceSelecterSeat, LocalDate dateOfFlight) {
        generateSize(size);
        this.allSeats = planeSeats.length * planeSeats[0].length;
        this.availableSeats = planeSeats.length * planeSeats[0].length;
        this.siteStart = siteStart;
        this.siteEnd = siteEnd;
        this.price = price;
        this.priceSelecterSeat = priceSelecterSeat;
        this.dateOfFlight = dateOfFlight;
        
    }

    //METHODS
    //Generate the size of the plane
    //Based on the size of the plane, it will generate the number of seats
    private void generateSize(SizeOfPlane size) {
        switch (size) {
            case SMALL:
                planeSeats = new int[30][2];
                break;
            case MEDIUM:
                planeSeats = new int[40][2];
                break;
            case LARGE:
                planeSeats = new int[40][3];
                break;
            default:
                planeSeats = new int[30][2];
        }

    }

    //GETTERS AND SETTERS
    //Return the price of the plane
    //If the user select a seat, the price will be increased
    //If have a few days to the flight, the price will be increased
    //If the plane is almost full, the price will be increased
    //If the plane is empty the price will drop
    public float getPrice(Boolean isSelecterSeat) {
        float endPrice = (isSelecterSeat) ? priceSelecterSeat + price : price;
        float AvailablePercentage = getAvailablePorcentage();
        long day = getDaysToFlight();
        //Not finish the method
        return 0;

    }

    // Return the available percentage of the plane
    private float getAvailablePorcentage() {
        return availableSeats / allSeats * 100;
    }

    // Return the days to the flight
    public long getDaysToFlight() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dateOfFlight);
    }

}
