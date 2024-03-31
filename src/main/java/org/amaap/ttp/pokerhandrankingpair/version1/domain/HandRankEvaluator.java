package org.amaap.ttp.pokerhandrankingpair.version1.domain;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.*;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandRankEvaluator {
    private static HandRankEvaluator handRankEvaluator;

    public static synchronized HandRankEvaluator getInstance() {
        if (handRankEvaluator == null)
            handRankEvaluator = new HandRankEvaluator();
        return handRankEvaluator;
    }

    public static HandRank evaluateRanking(Hand hand) {
        if (RoyalFlush.isRoyalFlush(hand)) {
            return HandRank.ROYAL_FLUSH;
        } else if (StraightFlush.isStraightFlush(hand)) {
            return HandRank.STRAIGHT_FLUSH;
        } else if (Straight.isStraight(hand)) {
            return HandRank.STRAIGHT;
        } else if (TwoPair.isTwoPair(hand)) {
            return HandRank.TWO_PAIR;
        } else if (Flush.isFlush(hand)) {
            return HandRank.FLUSH;
        }
        return HandRank.PAIR;

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