package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.Pair.isPair;
import static org.junit.jupiter.api.Assertions.*;

class PairTest {

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
        List<String> cards = Arrays.asList("HQ", "SQ", "CJ", "HA", "C3");

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
        List<String> cards = Arrays.asList("HQ", "SQ", "CJ", "HA", "C3");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isPair(hand);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ", "S2", "CJ", "HA", "C3");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isPair(hand);

        // assert
        assertFalse(actual);
    }
}