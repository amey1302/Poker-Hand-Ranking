package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;

public class PokerManager {
    public Card createCard(Suit suit, Rank rank) throws InvalidCardException {
        return Card.create(suit, rank);
    }

}

