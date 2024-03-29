package org.amaap.ttp.pokerhand.domain.ranking;

import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.amaap.ttp.pokerhand.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.model.HandRank;
import org.amaap.ttp.pokerhand.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.amaap.ttp.pokerhand.domain.ranking.ThreeOfAKind.isThreeOfAKind;
import static org.junit.jupiter.api.Assertions.*;

class ThreeOfAKindTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToIntializeTheInstanceOfThreeOfAKindClass() {
        // arrange
        ThreeOfAKind actual = new ThreeOfAKind();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForThreeOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("H3","H2","D3","C3","HA");
        Hand hand = Hand.create(cards);

        HandRank expected = HandRank.THREE_OF_A_KIND;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void shouldBeAbleToReturnTrueIfCardsPassedToIsThreeOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("H3","H2","D3","C3","HA");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isThreeOfAKind(hand);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsThreeOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HT","HJ","HQ","HK","HA");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isThreeOfAKind(hand);

        // assert
        assertFalse(actual);
    }
}