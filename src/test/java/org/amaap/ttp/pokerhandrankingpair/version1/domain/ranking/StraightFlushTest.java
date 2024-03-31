package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.StraightFlush.isStraightFlush;
import static org.junit.jupiter.api.Assertions.*;

class StraightFlushTest {

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
        List<String> cards = Arrays.asList("H3", "H4", "H5", "H6", "H7");
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
        List<String> cards = Arrays.asList("H5", "HJ", "HQ", "H3", "H9");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isStraightFlush(hand);

        // assert
        assertFalse(actual);
    }
}