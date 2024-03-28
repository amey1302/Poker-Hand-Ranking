package org.amaap.ttp.pokerhand.domain.validator;

import org.amaap.ttp.pokerhand.domain.model.Card;

import java.util.List;

public class HandValidator {
    public static boolean isInvalidHandCapacity(List<Card> cards) {
        return !isValidHandCapacity(cards);
    }

    static boolean isValidHandCapacity(List<Card> cards) {
        return cards.size() == 5;
    }
}
