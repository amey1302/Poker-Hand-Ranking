package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidSuitException;

import java.util.ArrayList;
import java.util.List;

public class CardParser {
    public static Card parseCard(String symbol) throws InvalidCardException {
        if (symbol.length() != 2 ) {
            throw new InvalidCardException("Invalid card symbol: " + symbol);
        }

        char suitSymbol = symbol.charAt(0);
        char rankSymbol = symbol.charAt(1);

        Suit suit = parseSuit(suitSymbol);
        Rank rank = parseRank(rankSymbol);

        return Card.create(suit, rank);
    }

    private static Suit parseSuit(char symbol) throws InvalidCardException {
        for (Suit suit : Suit.values()) {
            if (suit.getKeyword().charAt(0) == symbol) {
                return suit;
            }
        }
        throw new InvalidSuitException("Invalid suit symbol: " + symbol);
    }

    private static Rank parseRank(char symbol) throws InvalidCardRankException {
        for (Rank rank : Rank.values()) {
            if (rank.getAbbreviation().charAt(0) == symbol) {
                return rank;
            }
        }
        throw new InvalidCardRankException("Invalid rank symbol: " + symbol);
    }

    public static List<Card> parseCards(List<String> symbols) throws InvalidCardException {
        List<Card> cards = new ArrayList<>();
        for (String symbol : symbols) {
            cards.add(parseCard(symbol));
        }
        return cards;
    }
}
