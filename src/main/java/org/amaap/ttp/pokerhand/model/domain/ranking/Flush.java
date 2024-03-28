package org.amaap.ttp.pokerhand.model.domain.ranking;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Hand;
import org.amaap.ttp.pokerhand.model.domain.Suit;

import java.util.List;
import java.util.Map;

import static org.amaap.ttp.pokerhand.model.domain.HandRankEvaluator.suitCount;

public class Flush {
    public static boolean isFlush(Hand hand){
        List<Card> cards = hand.getCards();
        Map<Suit, Integer> suitCount = suitCount(cards);
        return suitCount.containsValue(5);

    }
}
