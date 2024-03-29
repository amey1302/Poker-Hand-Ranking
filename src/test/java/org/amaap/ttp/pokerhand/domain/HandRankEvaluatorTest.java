package org.amaap.ttp.pokerhand.domain;

import org.amaap.ttp.pokerhand.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.model.HandRank;
import org.amaap.ttp.pokerhand.domain.model.Rank;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HandRankEvaluatorTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfHandRankEvaluatorClass() {
        // arrange
        HandRankEvaluator actual = new HandRankEvaluator();

        // act & assert
        assertNotNull(actual);
    }
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