package org.amaap.ttp.pokerhand.model;

import org.amaap.ttp.pokerhand.model.domain.*;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;
import org.amaap.ttp.pokerhand.model.domain.HandRankEvaluator;

import java.util.List;

public class PokerManager {
    public Card createCard(Suit suit, Rank rank) throws InvalidCardException {
        return Card.create(suit, rank);
    }

    public Hand assignCardToHand(List<Card> expectedCards) throws InvalidHandCapacityException {
        return Hand.create(expectedCards);
    }

    public HandRank evaluateHandRanking(Hand hand) {
        return HandRankEvaluator.evaluateRanking(hand);
    }
}
