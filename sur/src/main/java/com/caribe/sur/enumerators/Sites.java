package com.caribe.sur.enumerators;

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
}
