package org.amaap.ttp.pokerhand.domain.model;

import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.amaap.ttp.pokerhand.domain.validator.HandValidator;

import java.util.List;

public class Hand {
    private List<Card> cards;

    private Hand(List<Card> cards) {
        this.cards = cards;
    }

    public static Hand create(List<Card> cards) throws InvalidHandCapacityException {
        if (cards == null || HandValidator.isInvalidHandCapacity(cards))
            throw new InvalidHandCapacityException("Hand should contains exactly five Cards");
        return new Hand(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getStringRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Card card : cards) {
            stringBuilder.append("\"").append(card.getSuit().getAbbreviation()).append(card.getRank().getAbbreviation()).append("\" ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
