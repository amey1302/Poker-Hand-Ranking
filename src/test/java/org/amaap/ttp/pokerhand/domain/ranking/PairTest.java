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

import static org.amaap.ttp.pokerhand.domain.ranking.Pair.isPair;
import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfPairClass() {
        // arrange
        Pair actual = new Pair();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForPair();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.PAIR;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTrueForPairCardsWithPairInstance() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForPair();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.PAIR;

        // act
        boolean actual = isPair(hand);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForFourOfAKind();
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isPair(hand);

        // assert
        assertFalse(actual);
    }
}