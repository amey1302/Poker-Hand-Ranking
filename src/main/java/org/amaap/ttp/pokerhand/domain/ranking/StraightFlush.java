package org.amaap.ttp.pokerhand.domain.ranking;

import org.amaap.ttp.pokerhand.domain.model.Hand;

public class StraightFlush {
    public static  boolean isStraightFlush(Hand hand){
        return Straight.isStraight(hand) && Flush.isFlush(hand);
    }
}
