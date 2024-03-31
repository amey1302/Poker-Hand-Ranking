package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.TwoPair.isTwoPair;
import static org.junit.jupiter.api.Assertions.*;

class TwoPairTest {


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
        List<String> cards = Arrays.asList("HQ", "S3", "DQ", "HA", "C3");
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.TWO_PAIR;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTrueIfCardsPassedToIsTwoPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("S2", "D2", "DQ", "H5", "C5");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isTwoPair(hand);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsTwoPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ", "S3", "DQ", "CA", "C4");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isTwoPair(hand);

        // assert
        assertFalse(actual);
    }

}