package com.caribe.sur.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.caribe.sur.enumerators.Sites;
import com.caribe.sur.enumerators.SizeOfPlane;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane {
    //ATRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    //Places of the plane X = Long of the plane, Y = Place in the both sites
    private User[][] planeSeats;

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
                planeSeats = new User[30][2];
                break;
            case MEDIUM:
                planeSeats = new User[40][2];
                break;
            case LARGE:
                planeSeats = new User[40][3];
                break;
            default:
                planeSeats = new User[30][2];
        }

    }

    //Return the price of the plane
    //If the user select a seat, the price will be increased
    //If have a few days to the flight, the price will be increased
    //If the plane is almost full, the price will be increased
    //If the plane is empty the price will drop
    public float getPrice(Boolean isSelecterSeat) {
        float endPrice = (isSelecterSeat) ? priceSelecterSeat + price : price;
        float AvailablePercentage = getAvailablePorcentage();
        long day = getDaysToFlight();
        
        endPrice += (AvailablePercentage < 20) ? endPrice * 0.15f : 0;
        endPrice += (day < 7) ? endPrice * 0.1f : 0;
        endPrice -= (AvailablePercentage > 50 && day < 7) ? endPrice * 0.2f : 0;    

        return endPrice;

    }

    // Return the available percentage of the plane
    private float getAvailablePorcentage() {
        return availableSeats / allSeats * 100;
    }

    // Return the days to the flight
    public long getDaysToFlight() {
        return ChronoUnit.DAYS.between(LocalDate.now(), dateOfFlight);
    }

    // Add a user to a specific seat
    // If the seat is available, the user will be added to the seat
    public boolean addUserToSeat(int x, int y, User user) {
        // Check if the seat is available
        if (planeSeats[x][y] == null) {
            planeSeats[x][y] = user;
            availableSeats--;
            return true; // User added successfully
        }
        return false; // Seat is already taken
    }


    //GETTERS AND SETTERS
    // Return the seats of the plane
    public User[][] getPlaneSeats() {
        return planeSeats;
    }

    // Return the number of the seat are available
    public int getAvailableSeats() {
        return availableSeats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPlaneSeats(User[][] planeSeats) {
        this.planeSeats = planeSeats;
    }

    public Sites getSiteStart() {
        return siteStart;
    }

    public void setSiteStart(Sites siteStart) {
        this.siteStart = siteStart;
    }

    public Sites getSiteEnd() {
        return siteEnd;
    }

    public void setSiteEnd(Sites siteEnd) {
        this.siteEnd = siteEnd;
    }

    public int getAllSeats() {
        return allSeats;
    }

    public void setAllSeats(int allSeats) {
        this.allSeats = allSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPriceSelecterSeat() {
        return priceSelecterSeat;
    }

    public void setPriceSelecterSeat(float priceSelecterSeat) {
        this.priceSelecterSeat = priceSelecterSeat;
    }

    public LocalDate getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(LocalDate dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    

}
