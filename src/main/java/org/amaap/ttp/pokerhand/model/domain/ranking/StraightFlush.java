package org.amaap.ttp.pokerhand.model.domain.ranking;

import org.amaap.ttp.pokerhand.model.domain.Hand;

import static org.amaap.ttp.pokerhand.model.domain.ranking.Flush.isFlush;
import static org.amaap.ttp.pokerhand.model.domain.ranking.Straight.isStraight;

public class StraightFlush {
    public static  boolean isStraightFlush(Hand hand){
        return isStraight(hand) && isFlush(hand);
    }
}
