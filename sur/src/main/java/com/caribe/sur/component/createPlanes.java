package com.caribe.sur.component;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caribe.sur.enumerators.Sites;
import com.caribe.sur.enumerators.SizeOfPlane;
import com.caribe.sur.model.Plane;
import com.caribe.sur.service.PlaneGestions;

import jakarta.annotation.PostConstruct;

@Component
public class createPlanes {

    @Autowired
    PlaneGestions planeGestions;

    private final int NUMBER_OF_PLANES = 10;

    @PostConstruct
    public void init() {

        int x = 0;
        Random random = new Random();
        while (x < NUMBER_OF_PLANES) {
            Sites from = Sites.getRandomSites();
            Sites to = Sites.getRandomSites();

            if (from == to) {
                continue;
            }
            planeGestions.savePlane(new Plane(SizeOfPlane.getRandomSites(), from, to, (int) random.nextInt(100, 200),
                    (int) random.nextInt(25, 50), LocalDate.now()));
            x++;
        }
    }
}
