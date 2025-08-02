package com.caribe.sur.model.DTO;

import com.caribe.sur.model.Enumerators.Sites;
import com.caribe.sur.model.Enumerators.SizeOfPlane;

public class Plane {
    private int sizeX;
    private int sizeY;

    private Sites siteStart;
    private Sites siteEnd;

    private float price;

    public Plane(SizeOfPlane size, Sites siteStart, Sites siteEnd, float price) {
        generateSize(size);
        this.siteStart = siteStart;
        this.siteEnd = siteEnd;
        this.price = price;
    }

    private void generateSize(SizeOfPlane size) {
        switch (size) {
            case SMALL:
                this.sizeX = 30;
                this.sizeY = 2;
                break;
            case MEDIUM:
                this.sizeX = 40;
                this.sizeY = 2;
                break;
            case LARGE:
                this.sizeX = 40;
                this.sizeY = 3;
                break;
        }
}
}
