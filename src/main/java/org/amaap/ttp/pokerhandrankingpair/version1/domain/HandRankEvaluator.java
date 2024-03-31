package org.amaap.ttp.pokerhandrankingpair.version1.domain;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Rank;
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

        Straight.isStraight(hand);
        return HandRank.STRAIGHT;
    }
    

}