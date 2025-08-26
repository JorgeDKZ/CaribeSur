package com.caribe.sur.enumerators;

import java.util.Random;

public enum Sites {

    España("España"),
    Francia("Francia"),
    Italia("Italia"),
    Alemania("Alemania"),
    ReinoUnido("Reino Unido"),
    EstadosUnidos("Estados Unidos");

    private final String sitio;

    Sites(String sitio) {
        this.sitio = sitio;
    }

    public String getSitio() {
        return sitio;
    }

    public static Sites getRandomSites(){
        Random random = new Random();
        Sites[] sites = Sites.values();
        int randomIndex = random.nextInt(0, sites.length);
        return sites[randomIndex];
    }

}
