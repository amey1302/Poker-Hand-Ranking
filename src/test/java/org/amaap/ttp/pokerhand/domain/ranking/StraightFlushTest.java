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

import static org.amaap.ttp.pokerhand.domain.ranking.StraightFlush.isStraightFlush;
import static org.junit.jupiter.api.Assertions.*;

class StraightFlushTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfStraightFlushClass() {
        // arrange
        StraightFlush actual = new StraightFlush();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForStraightFlush() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForStraightFlush();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT_FLUSH;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsStraightFlush() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForTwoPair();
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isStraightFlush(hand);

        // assert
        assertFalse(actual);
    }
}