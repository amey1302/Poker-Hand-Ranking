package org.amaap.ttp.pokerhand.model.domain;

import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidSuitException;

import java.util.Objects;

import static org.amaap.ttp.pokerhand.model.domain.validator.CardValidator.isInvalidCardRank;
import static org.amaap.ttp.pokerhand.model.domain.validator.CardValidator.isInvalidCardSuit;

public class Card {
    private Suit suit;
    private Rank rank;

    private Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public static Card create(Suit suit, Rank rank) throws InvalidCardException {
        if (isInvalidCardSuit(suit)) throw new InvalidSuitException("The Suit is Invalid " + suit);
        if (isInvalidCardRank(rank)) throw new InvalidCardRankException("The Card Rank is Invalid " + rank);
        return new Card(suit, rank);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format(suit + "_" + rank);
    }
}
