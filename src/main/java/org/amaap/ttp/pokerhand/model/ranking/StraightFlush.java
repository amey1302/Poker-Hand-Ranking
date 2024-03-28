package org.amaap.ttp.pokerhand.model.ranking;

import org.amaap.ttp.pokerhand.model.domain.Hand;

public class StraightFlush {
    public static  boolean isStraightFlush(Hand hand){
        return Straight.isStraight(hand) && Flush.isFlush(hand);
    }
}
