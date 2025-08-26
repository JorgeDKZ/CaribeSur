package com.caribe.sur.enumerators;

import java.util.Random;

public enum SizeOfPlane {
    SMALL,
    MEDIUM,
    LARGE;




    public static SizeOfPlane getRandomSites() {
        Random random = new Random();
        SizeOfPlane [] size = SizeOfPlane.values();
        int randomIndex = random.nextInt(0, size.length);
        return size[randomIndex];
    }

}