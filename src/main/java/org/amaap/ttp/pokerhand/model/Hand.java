package org.amaap.ttp.pokerhand.model;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;

import java.util.List;

public class Hand {
    private List<Card> cards;

    private Hand(List<Card> cards) {
        this.cards = cards;
    }

    public static Hand create(List<Card> cards) throws InvalidHandCapacityException {
        if (cards == null || isInvalidHandCapacity(cards))
            throw new InvalidHandCapacityException("Hand should contains exactly five Cards");
        return new Hand(cards);
    }

    private static boolean isInvalidHandCapacity(List<Card> cards) {
        return !isValidHandCapacity(cards);
    }

    private static boolean isValidHandCapacity(List<Card> cards) {
        return cards.size() == 5 ;
    }

    public List<Card> getCards() {
        return cards;
    }

}
