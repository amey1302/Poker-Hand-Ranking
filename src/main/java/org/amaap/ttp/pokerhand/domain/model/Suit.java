package org.amaap.ttp.pokerhand.domain.model;

public enum Suit {
    SPADE("S"), HEART("H"), CLUB("C"), DIAMOND("D");

    private final String abbreviation;

    Suit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

