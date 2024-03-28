package org.amaap.ttp.pokerhand.domain.ranking;

import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhand.domain.model.Suit;

import java.util.List;
import java.util.Map;

public class Flush {
    public static boolean isFlush(Hand hand){
        List<Card> cards = hand.getCards();
        Map<Suit, Integer> suitCount = HandRankEvaluator.suitCount(cards);
        return suitCount.containsValue(5);

    }
}
