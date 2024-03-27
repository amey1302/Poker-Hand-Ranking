package org.amaap.ttp.pokerhand.model.services;

import org.amaap.ttp.pokerhand.model.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandRankEvaluator {
    public static HandRank evaluateRanking(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Rank, Integer> rankCount = new HashMap<>();
        Map<Suit, Integer> suitCount = new HashMap<>();

        for(Card card: cards){
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0) + 1);
        }

        if (isStraightFlush(cards)){
            return HandRank.STRAIGHT_FLUSH;
        } else {
            return HandRank.HIGH_CARD;
        }

    }

    private static boolean isStraightFlush(List<Card> cards) {
        return true;
    }
}
