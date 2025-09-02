package com.caribe.sur.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * User model class representing a user in the system.
 */
@Entity
@Table(name = "Users")
public class User {

    // ATRIBUTES
    // Primary key is userName, userName is unique per user
    @Id
    private String userName;
    // Password for the user
    private String password;
    // Phone number for the user
    private int phone;
    // Optional field for user's Gmail
    private String gmail;
    // Role of the user, e.g., ADMIN, USER
    private String role;
    // List of the ticket has this user
    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("User")
    private List<Ticket> myTickets;

    // CONSTRUCTORS
    /**
     * Default constructor for JPA.
     */
    public User() {
    }

    public User(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    /**
     * Constructor for User class.
     * 
     * @param userName Unique username for the user
     * @param password Password for the user
     * @param phone    Phone number for the user
     * @param gmail    Optional Gmail address for the user
     * @param role     Role of the user (e.g., ADMIN, USER)
     */
    public User(String userName, String password, int phone, String gmail, String role) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.gmail = gmail;
        this.role = role;
    }

    public void addTicket(Ticket ticket) {
        myTickets.add(ticket);
    }

    // GETTERS AND SETTERS
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Ticket> getMyTickets() {
        return myTickets;
    }

    public void setMyTickets(List<Ticket> myTickets) {
        this.myTickets = myTickets;
    }

}
