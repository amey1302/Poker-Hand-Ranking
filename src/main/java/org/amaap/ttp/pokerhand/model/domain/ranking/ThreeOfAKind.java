package org.amaap.ttp.pokerhand.model.domain.ranking;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Hand;
import org.amaap.ttp.pokerhand.model.domain.Rank;

import java.util.List;
import java.util.Map;

import static org.amaap.ttp.pokerhand.model.domain.HandRankEvaluator.rankCount;

public class ThreeOfAKind {
    public static boolean isThreeOfAKind(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Rank, Integer> rankCount = rankCount(cards);
        return rankCount.containsValue(3);
    }
}
