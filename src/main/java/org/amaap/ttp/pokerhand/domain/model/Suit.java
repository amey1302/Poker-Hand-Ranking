package org.amaap.ttp.pokerhand.domain.model;

public enum Suit {
    SPADE("S"), HEART("H"), CLUB("C"), DIAMOND("D");

    private final String keyword;

    Suit(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}

