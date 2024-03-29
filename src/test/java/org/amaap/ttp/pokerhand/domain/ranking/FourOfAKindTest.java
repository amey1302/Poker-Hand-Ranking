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

import static org.amaap.ttp.pokerhand.domain.ranking.FourOfAKind.isFourOfAKind;
import static org.junit.jupiter.api.Assertions.*;

class FourOfAKindTest {

    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfFourOfAKindClass() {
        // arrange
        FourOfAKind actual = new FourOfAKind();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForFourOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForFourOfAKind();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.FOUR_OF_A_KIND;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsFourOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForTwoPair();
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isFourOfAKind(hand);

        // assert
        assertFalse(actual);
    }

}