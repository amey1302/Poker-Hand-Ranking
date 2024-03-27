package org.amaap.ttp.pokerhand.model.domain;

public enum HandRank {
    ROYAL_FLUSH,
    STRAIGHT_FLUSH,
    FOUR_OF_A_KIND,
    FULL_HOUSE,
    FLUSH,
    STRAIGHT,
    THREE_OF_A_KIND,
    TWO_PAIR,
    PAIR,
    HIGH_CARD;
    private Rank highestCard;

    public HandRank withHighestCard(Rank highestCard) {
        this.highestCard = highestCard;
        return this;
    }

    public Rank getHighestCard() {
        return highestCard;
    }


}
