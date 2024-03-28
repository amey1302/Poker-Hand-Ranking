package org.amaap.ttp.pokerhand.domain.ranking;

import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Hand;

import java.util.Comparator;
import java.util.List;

public class Straight {
    public static boolean isStraight(Hand hand){
        List<Card> cards = hand.getCards();
        cards.sort(Comparator.comparing(card -> card.getRank()));
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).getRank().ordinal() - cards.get(i).getRank().ordinal() != 1) {
                return false;
            }
        }
        return true;

    }
}
