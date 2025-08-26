package com.caribe.sur.enumerators;

import java.util.Random;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    Role(String string) {

    }

    public static Role getRandomSites() {
        Random random = new Random();
        Role [] roles = Role.values();
        int randomIndex = random.nextInt(0, roles.length);
        return roles[randomIndex];
    }
}
