package com.caribe.sur.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tickets")
public class Ticket{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private int rows;
    private int colums;

    @ManyToOne
    @JoinColumn(name = "Users")
    @JsonBackReference("User")
    private User passenger;

    @ManyToOne
    @JoinColumn(name = "Planes")
    @JsonBackReference("Plane")
    private Plane plane;

    public Ticket() {
    }

    public Ticket(int rows, int colums, User passenger, Plane plane) {
        this.rows = rows;
        this.colums = colums;
        this.passenger = passenger;
        this.plane = plane;
    }

    public void deleteTicket() {
        passenger.deleteTicket(this);
        plane.deleteTicket(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ticket other = (Ticket) obj;
        if (id != other.id)
            return false;
        return true;
    }

    // GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColums() {
        return colums;
    }

    public void setColums(int colums) {
        this.colums = colums;
    }

    public User getPassenger() {
        return passenger;
    }

    public void setPassenger(User passenger) {
        this.passenger = passenger;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

}
