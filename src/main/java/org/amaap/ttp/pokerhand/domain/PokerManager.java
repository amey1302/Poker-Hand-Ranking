package org.amaap.ttp.pokerhand.domain;

import org.amaap.ttp.pokerhand.domain.model.CardParser;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.model.HandRank;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;

import java.util.List;

public class PokerManager {
    private static PokerManager pokerManager;

    public static synchronized PokerManager getInstance() {
        if (pokerManager == null)
            pokerManager = new PokerManager();
        return pokerManager;
    }

    public Hand createHandFromSymbols(List<String> symbols) throws InvalidCardException, InvalidHandCapacityException {
         CardParser.parseCards(symbols);
        return Hand.create(symbols);
    }

    public HandRank evaluateHandRanking(Hand hand) {
        return HandRankEvaluator.evaluateRanking(hand);
    }
}
