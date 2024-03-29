package org.amaap.ttp.pokerhand.domain.model;

import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;

import java.util.ArrayList;
import java.util.List;

public class CardParser {
    public static Card parseCard(String symbol) throws InvalidCardException {
        if (symbol.length() != 2) {
            throw new InvalidCardException("Invalid card symbol: " + symbol);
        }

        char suitSymbol = symbol.charAt(0);
        char rankSymbol = symbol.charAt(1);

        Suit suit = parseSuit(suitSymbol);
        Rank rank = parseRank(rankSymbol);

        if (suit == null || rank == null) {
            throw new InvalidCardException("Invalid card symbol: " + symbol);
        }

        return Card.create(suit, rank);
    }
    private static Suit parseSuit(char symbol) {
        for (Suit suit : Suit.values()) {
            if (suit.getKeyword().charAt(0) == symbol) {
                return suit;
            }
        }
        return null;
    }
    private static Rank parseRank(char symbol) {
        for (Rank rank : Rank.values()) {
            if (rank.getAbbreviation().charAt(0) == symbol) {
                return rank;
            }
        }
        return null;
    }

    public static List<Card> parseCards(List<String> symbols) throws InvalidCardException {
        List<Card> cards = new ArrayList<>();
        for (String symbol : symbols) {
            cards.add(parseCard(symbol));
        }
        return cards;
    }
}
