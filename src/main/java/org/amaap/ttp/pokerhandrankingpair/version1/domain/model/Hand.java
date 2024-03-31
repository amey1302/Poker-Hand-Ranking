package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;

import java.util.List;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.model.validator.HandValidator.isInvalidHandCapacity;

public class Hand {
    private List<Card> cards;

    private Hand(List<Card> cards) {
        this.cards = cards;
    }


    public static Hand create(List<String> symbols) throws InvalidCardException, InvalidHandCapacityException {
        if (symbols == null || isInvalidHandCapacity(symbols))
            throw new InvalidHandCapacityException("Hand should contain exactly five Cards");
        List<Card> cards = CardParser.parseCards(symbols);
        return new Hand(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getStringRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Card card : cards) {
            stringBuilder.append("\"").append(card.getSuit().getKeyword()).append(card.getRank().getAbbreviation()).append("\"");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

