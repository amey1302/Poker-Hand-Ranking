package org.amaap.ttp.pokerhand.model.domain.ranking;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Hand;
import org.amaap.ttp.pokerhand.model.domain.Rank;
import org.amaap.ttp.pokerhand.model.domain.Suit;

import java.util.List;
import java.util.Map;

import static org.amaap.ttp.pokerhand.model.domain.HandRankEvaluator.suitCount;
import static org.amaap.ttp.pokerhand.model.domain.ranking.StraightFlush.isStraightFlush;

public class RoyalFlush {
    public static boolean isRoyalFlush(Hand hand){
        List<Card> cards = hand.getCards();
        Map<Suit, Integer> suitCount = suitCount(cards);
        return isStraightFlush(hand) && cards.stream().anyMatch(card -> card.getRank() == Rank.ACE);

    }

}
