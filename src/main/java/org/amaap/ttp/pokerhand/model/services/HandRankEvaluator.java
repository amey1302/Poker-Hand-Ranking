package org.amaap.ttp.pokerhand.model.services;

import org.amaap.ttp.pokerhand.model.domain.Hand;
import org.amaap.ttp.pokerhand.model.domain.HandRank;

import static org.amaap.ttp.pokerhand.model.ranking.RoyalFlush.isRoyalFlush;

public class HandRankEvaluator {
    public static String evaluateRanking(Hand hand) {
        if (isRoyalFlush(hand)) {
            return HandRank.ROYAL_FLUSH.getLabel();
        } else {
            return HandRank.HIGH_CARD.getLabel();
        }

    }
}
