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

import static org.amaap.ttp.pokerhand.domain.ranking.RoyalFlush.isRoyalFlush;
import static org.junit.jupiter.api.Assertions.*;

class RoyalFlushTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfRoyalFlushClass() {
        // arrange
        RoyalFlush actual = new RoyalFlush();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForRoyalFlush() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForRoyalFlush();
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.ROYAL_FLUSH;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsRoyalFlush() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForHighCard();
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isRoyalFlush(hand);

        // assert
        assertFalse(actual);
    }
}