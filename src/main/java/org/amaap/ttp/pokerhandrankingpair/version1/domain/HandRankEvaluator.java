package org.amaap.ttp.pokerhandrankingpair.version1.domain;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.*;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.Flush.isFlush;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.FourOfKind.isFourOfKind;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.FullHouse.isFullHouse;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.Pair.isPair;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.RoyalFlush.isRoyalFlush;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.Straight.isStraight;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.StraightFlush.isStraightFlush;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.ThreeOfKind.isThreeOfKind;
import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.TwoPair.isTwoPair;

public class HandRankEvaluator {
    private static HandRankEvaluator handRankEvaluator;

    public static synchronized HandRankEvaluator getInstance() {
        if (handRankEvaluator == null)
            handRankEvaluator = new HandRankEvaluator();
        return handRankEvaluator;
    }

    public static HandRank evaluateRanking(Hand hand) {
        List<Card> cards = hand.getCards();
        if (RoyalFlush.isRoyalFlush(hand)) {
            return HandRank.ROYAL_FLUSH;
        } else if (StraightFlush.isStraightFlush(hand)) {
            return HandRank.STRAIGHT_FLUSH;
        } else if (FourOfKind.isFourOfKind(hand)) {
            return HandRank.FOUR_OF_A_KIND;
        } else if (FullHouse.isFullHouse(hand)) {
            return HandRank.FULL_HOUSE;
        } else if (Flush.isFlush(hand)) {
            return HandRank.FLUSH;
        } else if (Straight.isStraight(hand)) {
            return HandRank.STRAIGHT;
        } else if (ThreeOfKind.isThreeOfKind(hand)) {
            return HandRank.THREE_OF_A_KIND;
        } else if (TwoPair.isTwoPair(hand)) {
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