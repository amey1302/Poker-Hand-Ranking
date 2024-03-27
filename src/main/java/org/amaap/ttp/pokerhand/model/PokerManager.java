package org.amaap.ttp.pokerhand.model;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Rank;
import org.amaap.ttp.pokerhand.model.domain.Suit;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;

import java.util.List;

public class PokerManager {
    public Card createCard(Suit suit, Rank rank) throws InvalidCardException {
        return Card.create(suit, rank);
    }


}
