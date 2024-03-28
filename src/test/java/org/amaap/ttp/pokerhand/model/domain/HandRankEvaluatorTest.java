package org.amaap.ttp.pokerhand.model.domain;

import org.amaap.ttp.pokerhand.model.builder.CardBuilder;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandRankEvaluatorTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToReturnTheRankForHighCard() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForHighCard();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.HIGH_CARD;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForHighCardWithHighRankCard() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForHighCard();
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.HIGH_CARD.withHighestCard(Rank.NINE);

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
}