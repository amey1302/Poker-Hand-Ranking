package org.amaap.ttp.pokerhand.domain.ranking;

import org.amaap.ttp.pokerhand.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhand.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.model.HandRank;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.amaap.ttp.pokerhand.domain.ranking.TwoPair.isTwoPair;
import static org.junit.jupiter.api.Assertions.*;

class TwoPairTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfTwoPairClass() {
        // arrange
        TwoPair actual = new TwoPair();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForTwoPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForTwoPair();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.TWO_PAIR;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsTwoPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForHighCard();
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isTwoPair(hand);

        // assert
        assertFalse(actual);
    }
}