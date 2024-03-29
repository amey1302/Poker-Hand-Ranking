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

import static org.amaap.ttp.pokerhand.domain.ranking.Flush.isFlush;
import static org.junit.jupiter.api.Assertions.*;

class FlushTest {

    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfFlushClass() {
        // arrange
        Flush actual = new Flush();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForFLUSH() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForFlush();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.FLUSH;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsFlush() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForTwoPair();
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isFlush(hand);

        // assert
        assertFalse(actual);
    }

}