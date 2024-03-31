package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.ThreeOfKind.isThreeOfKind;
import static org.junit.jupiter.api.Assertions.*;

class ThreeOfKindTest {

    @Test
    void shouldBeAbleToIntializeTheInstanceOfThreeOfAKindClass() {
        // arrange
        ThreeOfKind actual = new ThreeOfKind();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForThreeOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("H3", "H2", "D3", "C3", "HA");
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
        List<String> cards = Arrays.asList("H3", "H2", "D3", "C3", "HA");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isThreeOfKind(hand);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsThreeOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HT", "HJ", "HQ", "HK", "HA");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isThreeOfKind(hand);

        // assert
        assertFalse(actual);
    }
}