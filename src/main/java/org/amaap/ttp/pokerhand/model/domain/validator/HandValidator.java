package org.amaap.ttp.pokerhand.model.domain.validator;

import org.amaap.ttp.pokerhand.model.domain.Card;

import java.util.List;

public class HandValidator {
    public static boolean isInvalidHandCapacity(List<Card> cards) {
        return !isValidHandCapacity(cards);
    }

    private static boolean isValidHandCapacity(List<Card> cards) {
        return cards.size() == 5;
    }
}
