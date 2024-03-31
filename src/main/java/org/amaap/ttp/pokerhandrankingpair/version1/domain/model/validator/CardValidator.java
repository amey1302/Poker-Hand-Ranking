package org.amaap.ttp.pokerhandrankingpair.version1.domain.model.validator;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Rank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Suit;

import java.util.EnumSet;

public class CardValidator {

    public static boolean isInvalidCardRank(Rank rank) {
        return !isValidCardRank(rank);
    }

    private static boolean isValidCardRank(Rank rank) {
        return EnumSet.allOf(Rank.class).contains(rank);
    }

    public static boolean isInvalidCardSuit(Suit suit) {
        return !isValidCardSuit(suit);
    }

    private static boolean isValidCardSuit(Suit suit) {
        return EnumSet.allOf(Suit.class).contains(suit);
    }

}
