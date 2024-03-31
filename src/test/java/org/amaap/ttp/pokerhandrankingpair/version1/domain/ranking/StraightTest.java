package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.Straight.isStraight;
import static org.junit.jupiter.api.Assertions.*;

class StraightTest {

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
        List<String> cards = Arrays.asList("H4", "S5", "D6", "H7", "C8");
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void shouldBeAbleToReturnTrueIfCardsPassedToIsStraight() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("H2", "S3", "D4", "H5", "C6");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isStraight(hand);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsStraight() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ", "S3", "DJ", "HA", "C3");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isStraight(hand);

        // assert
        assertFalse(actual);
    }
}