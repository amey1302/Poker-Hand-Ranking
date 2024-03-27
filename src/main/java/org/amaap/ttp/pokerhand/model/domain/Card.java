package org.amaap.ttp.pokerhand.model.domain;

import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidSuitException;

import java.util.EnumSet;
import java.util.Objects;

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

    private static boolean isInvalidCardRank(Rank rank) {
        return !isValidCardRank(rank);
    }

    private static boolean isValidCardRank(Rank rank) {
        return EnumSet.allOf(Rank.class).contains(rank);
    }

    private static boolean isInvalidCardSuit(Suit suit) {
        return !isValidCardSuit(suit);
    }

    private static boolean isValidCardSuit(Suit suit) {
        return EnumSet.allOf(Suit.class).contains(suit);
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

    @Override
    public String toString() {
        return String.format(suit + "" + rank);
    }
}
