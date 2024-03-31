package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;

public class StraightFlush {
    public static boolean isStraightFlush(Hand hand){
        return Straight.isStraight(hand) && Flush.isFlush(hand);
    }
}
