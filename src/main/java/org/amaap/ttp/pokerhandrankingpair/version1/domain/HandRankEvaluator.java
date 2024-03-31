package org.amaap.ttp.pokerhandrankingpair.version1.domain;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Rank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.Pair;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.Straight;

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

        if (Straight.isStraight(hand))
            return HandRank.STRAIGHT;
        else if(Pair.isPair(hand))
            return HandRank.PAIR;
        return HandRank.TWO_PAIR;

    }

    public static Map<Rank, Integer> rankCount(List<Card> cards) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Card card : cards) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        return rankCount;
    }

}