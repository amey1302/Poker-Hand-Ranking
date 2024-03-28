package org.amaap.ttp.pokerhand.model.domain.ranking;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Hand;
import org.amaap.ttp.pokerhand.model.domain.Rank;

import java.util.List;
import java.util.Map;

import static org.amaap.ttp.pokerhand.model.domain.HandRankEvaluator.rankCount;

public class TwoPair {
    public static boolean isTwoPair(Hand hand){
        List<Card> cards = hand.getCards();
        Map<Rank, Integer> rankCount = rankCount(cards);
        int pairCount = 0;
        for (int count : rankCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;

    }
}
