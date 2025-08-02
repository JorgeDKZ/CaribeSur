package com.caribe.sur.model.logic;

import java.util.HashMap;

import com.caribe.sur.model.DTO.User;

public class Warehouse {

    private static HashMap<String, User> users = new HashMap<>();

    public static boolean addUser(User user) {
        if(users.get(user.getUserName()) == null) {
            users.put(user.getUserName(), user);
            return true;
        } else{
            return false;
        }
    }

    public static User getUser(String userName) {
        return users.get(userName);
    }
}
