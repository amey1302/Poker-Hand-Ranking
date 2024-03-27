package org.amaap.ttp.pokerhand.model.services;

import org.amaap.ttp.pokerhand.model.domain.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandRankEvaluator {
    public static HandRank evaluateRanking(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Rank, Integer> rankCount = new HashMap<>();
        Map<Suit, Integer> suitCount = new HashMap<>();

        for (Card card : cards) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0) + 1);
        }

        if (isRoyalFlush(cards, suitCount)) {
            return HandRank.ROYAL_FLUSH;
        } else if (isStraightFlush(cards, rankCount, suitCount)) {
            return HandRank.STRAIGHT_FLUSH;
        } else if (isFourOfAKind(rankCount)) {
            return HandRank.FOUR_OF_A_KIND;
        } else if (isFullHouse(rankCount)) {
            return HandRank.FULL_HOUSE;
        } else if (isFlush(suitCount)) {
            return HandRank.FLUSH;
        } else if (isStraight(cards, rankCount)) {
            return HandRank.STRAIGHT;
        } else if (isThreeOfAKind(rankCount)) {
            return HandRank.THREE_OF_A_KIND;
        } else if (isTwoPair(rankCount)) {
            return HandRank.TWO_PAIR;
        } else if (isPair(rankCount)) {
            return HandRank.PAIR;
        } else {
            return HandRank.HIGH_CARD;
        }
    }

    static boolean isRoyalFlush(List<Card> cards, Map<Suit, Integer> suitCount) {
        return isStraightFlush(cards, null, suitCount) && cards.stream().anyMatch(card -> card.getRank() == Rank.ACE);
    }

    static boolean isStraightFlush(List<Card> cards, Map<Rank, Integer> rankCount, Map<Suit, Integer> suitCount) {

        return isStraight(cards, rankCount) && isFlush(suitCount);
    }

    static boolean isFourOfAKind(Map<Rank, Integer> rankCount) {

        return rankCount.containsValue(4);
    }

    static boolean isFullHouse(Map<Rank, Integer> rankCount) {

        return rankCount.containsValue(3) && rankCount.containsValue(2);
    }

    static boolean isFlush(Map<Suit, Integer> suitCount) {
        return suitCount.containsValue(5);
    }

    static boolean isStraight(List<Card> cards, Map<Rank, Integer> rankCount) {
        cards.sort(Comparator.comparing(card -> card.getRank()));
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getRank().ordinal() - cards.get(i).getRank().ordinal() != 1) {
                return false;
            }
        }
        return true;
    }

    static boolean isThreeOfAKind(Map<Rank, Integer> rankCount) {

        return rankCount.containsValue(3);
    }

    static boolean isTwoPair(Map<Rank, Integer> rankCount) {

        int pairCount = 0;
        for (int count : rankCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    static boolean isPair(Map<Rank, Integer> rankCount) {

        return rankCount.containsValue(2);
    }
}
