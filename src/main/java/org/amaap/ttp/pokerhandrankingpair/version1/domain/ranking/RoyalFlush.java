package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Rank;

import java.util.List;

public class RoyalFlush {
    public static boolean isRoyalFlush(Hand hand){
        List<Card> cards = hand.getCards();
        return StraightFlush.isStraightFlush(hand) && cards.stream().anyMatch(card -> card.getRank() == Rank.ACE);

    }

}
