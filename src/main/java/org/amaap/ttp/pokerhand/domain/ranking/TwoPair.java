package org.amaap.ttp.pokerhand.domain.ranking;

import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhand.domain.model.Rank;

import java.util.List;
import java.util.Map;

public class TwoPair {
    public static boolean isTwoPair(Hand hand){
        List<Card> cards = hand.getCards();
        Map<Rank, Integer> rankCount = HandRankEvaluator.rankCount(cards);
        int pairCount = 0;
        for (int count : rankCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;

    }
}
