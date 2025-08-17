package com.caribe.sur.model;

import java.util.List;

public class Backup {

    private List<Plane> planes;
    private List<User> users;

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
}
