package com.caribe.sur.model;

import java.util.List;

public class Backup {

    private List<Plane> planes;
    private List<User> users;
    private List<Ticket> tickets;

    public Backup() {}

    public Backup(List<Plane> planes, List<User> users) {
        this.planes = planes;
        this.users = users;
    }

    public List<Plane> getPlanes() {
        return planes;
    }
    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
