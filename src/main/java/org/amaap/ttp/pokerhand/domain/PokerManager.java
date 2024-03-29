package org.amaap.ttp.pokerhand.domain;

import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;

import org.amaap.ttp.pokerhand.domain.model.*;

import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;

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
