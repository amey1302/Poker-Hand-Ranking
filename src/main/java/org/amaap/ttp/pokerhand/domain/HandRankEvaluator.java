package org.amaap.ttp.pokerhand.domain;

import org.amaap.ttp.pokerhand.domain.model.*;
import org.amaap.ttp.pokerhand.domain.ranking.StraightFlush;
import org.amaap.ttp.pokerhand.domain.ranking.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.amaap.ttp.pokerhand.domain.ranking.Flush.isFlush;
import static org.amaap.ttp.pokerhand.domain.ranking.FourOfAKind.isFourOfAKind;
import static org.amaap.ttp.pokerhand.domain.ranking.FullHouse.isFullHouse;
import static org.amaap.ttp.pokerhand.domain.ranking.RoyalFlush.isRoyalFlush;
import static org.amaap.ttp.pokerhand.domain.ranking.Straight.isStraight;
import static org.amaap.ttp.pokerhand.domain.ranking.ThreeOfAKind.isThreeOfAKind;
import static org.amaap.ttp.pokerhand.domain.ranking.TwoPair.isTwoPair;

public class HandRankEvaluator {
    public static HandRank evaluateRanking(Hand hand) {
        List<Card> cards = hand.getCards();

        if (isRoyalFlush(hand)) {
            return HandRank.ROYAL_FLUSH;
        } else if (StraightFlush.isStraightFlush(hand)) {
            return HandRank.STRAIGHT_FLUSH;
        } else if (isFourOfAKind(hand)) {
            return HandRank.FOUR_OF_A_KIND;
        } else if (isFullHouse(hand)) {
            return HandRank.FULL_HOUSE;
        } else if (isFlush(hand)) {
            return HandRank.FLUSH;
        } else if (isStraight(hand)) {
            return HandRank.STRAIGHT;
        } else if (isThreeOfAKind(hand)) {
            return HandRank.THREE_OF_A_KIND;
        } else if (isTwoPair(hand)) {
            return HandRank.TWO_PAIR;
        } else if (Pair.isPair(hand)) {
            return HandRank.PAIR;
        } else {
            cards.sort(Comparator.comparing(card -> card.getRank()));
            Rank highestCard = cards.get(cards.size() - 1).getRank();
            return HandRank.HIGH_CARD.withHighestCard(highestCard);
        }
    }
    public static Map<Rank, Integer> rankCount(List<Card> cards) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : cards) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        return rankCount;
    }

    public static Map<Suit, Integer> suitCount(List<Card> cards) {
        Map<Suit, Integer> suitCount = new HashMap<>();
        for (Card card : cards) {
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0) + 1);
        }
        return suitCount;
    }
}