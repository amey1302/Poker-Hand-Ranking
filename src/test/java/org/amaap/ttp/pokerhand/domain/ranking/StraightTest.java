package org.amaap.ttp.pokerhand.domain.ranking;

import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.amaap.ttp.pokerhand.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.model.HandRank;
import org.amaap.ttp.pokerhand.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.amaap.ttp.pokerhand.domain.ranking.Straight.isStraight;
import static org.junit.jupiter.api.Assertions.*;

class StraightTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfStraightClass() {
        // arrange
        Straight straight = new Straight();

        // act & assert
        assertNotNull(straight);
    }

    @Test
    void shouldBeAbleToReturnTheRankForStraight() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForStraight();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsStraight() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForTwoPair();
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isStraight(hand);

        // assert
        assertFalse(actual);
    }
}