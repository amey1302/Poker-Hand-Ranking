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
        if (cards.size() > 5) throw new InvalidHandCapacityException("Hand should contains exactly five Cards");
        return new Hand(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

}
