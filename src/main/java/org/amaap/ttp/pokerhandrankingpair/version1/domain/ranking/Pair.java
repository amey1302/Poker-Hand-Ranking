package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Rank;

import java.util.List;
import java.util.Map;

public class Pair {
    public static boolean isPair(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Rank, Integer> rankCount = HandRankEvaluator.rankCount(cards);

        return rankCount.containsValue(2);

    }
}