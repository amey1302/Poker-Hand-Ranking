package org.amaap.ttp.pokerhandrankingpair.version1.domain;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.*;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;

import java.util.List;

public class PokerManager {
    private static PokerManager pokerManager;

    public static synchronized PokerManager getInstance() {
        if (pokerManager == null)
            pokerManager = new PokerManager();
        return pokerManager;
    }

    public Card createCard(Suit suit, Rank rank) throws InvalidCardException {
        return Card.create(suit, rank);
    }

    public Hand createHand(List<String> symbols) throws InvalidCardException, InvalidHandCapacityException {
        CardParser.parseCards(symbols);
        return Hand.create(symbols);
    }

    public HandRank evaluateHandRanking(Hand hand) {
        return HandRankEvaluator.evaluateRanking(hand);
    }
}

