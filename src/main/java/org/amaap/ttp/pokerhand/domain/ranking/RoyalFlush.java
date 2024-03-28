package org.amaap.ttp.pokerhand.domain.ranking;

import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhand.domain.model.Suit;
import org.amaap.ttp.pokerhand.domain.model.Rank;

import java.util.List;
import java.util.Map;

public class RoyalFlush {
    public static boolean isRoyalFlush(Hand hand){
        List<Card> cards = hand.getCards();
        Map<Suit, Integer> suitCount = HandRankEvaluator.suitCount(cards);
        return StraightFlush.isStraightFlush(hand) && cards.stream().anyMatch(card -> card.getRank() == Rank.ACE);

    }

}
