package org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Hand;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.HandRank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.amaap.ttp.pokerhandrankingpair.version1.domain.ranking.FullHouse.isFullHouse;
import static org.junit.jupiter.api.Assertions.*;

class FullHouseTest {

    @Test
    void shouldBeAbleToIntializeTheInstanceOfFullHouseClass() {
        // arrange
        FullHouse actual = new FullHouse();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForFullHouse() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ","SQ","CQ","H3","C3");

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.FULL_HOUSE;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnFalseIfDifferentCardsPassedToIsFullHouse() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ","S2","CQ","H3","C3");
        Hand hand = Hand.create(cards);

        // act
        boolean actual = isFullHouse(hand);

        // assert
        assertFalse(actual);
    }
}