package com.caribe.sur.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.caribe.sur.enumerators.Seats;
import com.caribe.sur.enumerators.Sites;
import com.caribe.sur.enumerators.SizeOfPlane;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Planes")
public class Plane {
    // ATRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    // List of the ticket has this plane
    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("Plane")
    private List<Ticket> planeSeats;

    // Site where the plane starts
    private Sites siteStart;
    // Site where the plane going to end
    private Sites siteEnd;

    // Columns of the plane
    private int columns;
    // All seats of the plane
    private int allSeats;
    // Available seats of the plane
    private int availableSeats;

    // Default price of the plane
    private float price;
    private float priceSelecterSeat;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    private String date;

    // CONSTRUCTOR
    public Plane() {
    }

    public Plane(SizeOfPlane size, Sites siteStart, Sites siteEnd, float price, float priceSelecterSeat,
            LocalDate localDateTime) {
        generateSize(size);
        availableSeats = allSeats;
        this.siteStart = siteStart;
        this.siteEnd = siteEnd;
        this.price = price;
        this.priceSelecterSeat = priceSelecterSeat;
        date = localDateTime.format(formatter);

    }

    // METHODS
    // Generate the size of the plane
    // Based on the size of the plane, it will generate the number of seats
    private void generateSize(SizeOfPlane size) {
        switch (size) {
            case SMALL:
                allSeats = 40;
                columns = 4;
                break;
            case MEDIUM:
                allSeats = 60;
                columns = 4;
                break;
            case LARGE:
                allSeats = 90;
                columns = 6;
                break;
            default:
                allSeats = 40;
                columns = 4;
        }

    }

    // Return the price of the plane
    // If the user select a seat, the price will be increased
    // If have a few days to the flight, the price will be increased
    // If the plane is almost full, the price will be increased
    // If the plane is empty the price will drop

    @JsonIgnore
    public float getPrice(Boolean isSelecterSeat) {
        float endPrice = (isSelecterSeat) ? priceSelecterSeat + price : price;
        float AvailablePercentage = getAvailablePorcentage();
        int day = getDaysToFly();

        endPrice += (AvailablePercentage < 20) ? endPrice * 0.15f : 0;
        endPrice += (day < 7) ? endPrice * 0.1f : 0;
        endPrice -= (AvailablePercentage > 50 && day < 7) ? endPrice * 0.2f : 0;

        return endPrice;

    }

    @JsonIgnore
    private int getDaysToFly() {
        LocalDate local = LocalDate.now();
        LocalDate date = LocalDate.parse(this.date, formatter);
        Period period;
        try {
            period = Period.between(local, date);
        } catch (Exception e) {
            return 0;
        }

        return period.getDays();
    }

    // Return the available percentage of the plane
    private float getAvailablePorcentage() {
        return availableSeats / allSeats * 100;
    }

    @JsonIgnore
    public Seats[][] getSeats() {
        Seats[][] seats = getDefaultSeats();

        for (int x = 0; x < planeSeats.size(); x++) {

            seats[planeSeats.get(x).getRows()][planeSeats.get(x).getColums()] = Seats.NOT_AVALIABLE;
        }

        return seats;
    }

    @JsonIgnore
    private Seats[][] getDefaultSeats() {
        Seats[][] seats = new Seats[allSeats / columns][columns];

        for (int x = 0; x < seats.length; x++) {
            for (int y = 0; y < seats[0].length; y++) {
                seats[x][y] = Seats.AVALIABLE;
            }
        }

        return seats;
    }

    public boolean isAvaliableSeat(int rows, int columns) {
        return !planeSeats.stream().anyMatch(
                (ticket -> ticket.getColums() == columns && ticket.getRows() == rows));
    }

    public void addTicket(Ticket ticket) {
        planeSeats.add(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        planeSeats.remove(ticket);
    }

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getPlaneSeats() {
        return planeSeats;
    }

    public void setPlaneSeats(List<Ticket> planeSeats) {
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

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getAllSeats() {
        return allSeats;
    }

    public void setAllSeats(int allSeats) {
        this.allSeats = allSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
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

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateTimeFormatter formatter) {
        Plane.formatter = formatter;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
