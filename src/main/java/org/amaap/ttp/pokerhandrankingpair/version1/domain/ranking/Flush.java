package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Suit;

import java.util.List;
import java.util.Map;

public class Flush {
    public static boolean isFlush(Hand hand){
        List<Card> cards = hand.getCards();
        Map<Suit, Integer> suitCount = HandRankEvaluator.suitCount(cards);
        return suitCount.containsValue(5);

    }
}
