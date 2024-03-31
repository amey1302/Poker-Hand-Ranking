package org.amaap.ttp.pokerhandrankingpair.version1.domain.model.validator;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;

import java.util.List;

public class HandValidator {
    public static boolean isInvalidHandCapacity(List<String> symbols) {
        return !isValidHandCapacity(symbols);
    }

    static boolean isValidHandCapacity(List<String> symbols) {
        return symbols.size() == 5;
    }
}
