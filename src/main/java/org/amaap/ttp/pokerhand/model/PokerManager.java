package org.amaap.ttp.pokerhand.model;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Rank;
import org.amaap.ttp.pokerhand.model.domain.Suit;

public class PokerManager {
    public Card createCard(Suit suit, Rank rank) {
        return new Card(suit,rank);
    }
}
