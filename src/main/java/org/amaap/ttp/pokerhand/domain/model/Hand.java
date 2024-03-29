package org.amaap.ttp.pokerhand.domain.model;

import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.amaap.ttp.pokerhand.domain.model.validator.HandValidator;

import java.util.List;

public class Hand {
    private List<Card> cards;

    private Hand(List<Card> cards) {
        this.cards = cards;
    }


    public static Hand create(List<String> symbols) throws InvalidCardException, InvalidHandCapacityException {
        if(symbols == null)
            throw new InvalidHandCapacityException("Hand should contain exactly five Cards");
        List<Card> cards = CardParser.parseCards(symbols);
        if (cards == null || HandValidator.isInvalidHandCapacity(cards))
            throw new InvalidHandCapacityException("Hand should contain exactly five Cards");
        return new Hand(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getStringRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Card card : cards) {
            stringBuilder.append("\"").append(card.getSuit().getKeyword()).append(card.getRank().getAbbreviation()).append("\" ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
