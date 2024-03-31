package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.Flush.isFlush;
import static org.junit.jupiter.api.Assertions.*;

class FlushTest {

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
        List<String> cards = Arrays.asList("HA", "H2", "H3", "H4", "H5");
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
        List<String> cards = Arrays.asList("HQ", "SQ", "CQ", "H3", "C3");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isFlush(hand);

        // assert
        assertFalse(actual);
    }

}