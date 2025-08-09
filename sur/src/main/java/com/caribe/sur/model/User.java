package com.caribe.sur.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * User model class representing a user in the system.
 */
@Entity
@Table(name = "users")
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

    // CONSTRUCTORS
    /**
     * Default constructor for JPA.
     */
    public User() {
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
}
