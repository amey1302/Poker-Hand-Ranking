package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidSuitException;

import java.util.Objects;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.model.validator.CardValidator.isInvalidCardRank;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.model.validator.CardValidator.isInvalidCardSuit;

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
