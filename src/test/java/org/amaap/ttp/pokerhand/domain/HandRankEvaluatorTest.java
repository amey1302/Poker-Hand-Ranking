package org.amaap.ttp.pokerhand.domain;

import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.model.HandRank;
import org.amaap.ttp.pokerhand.domain.model.Rank;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HandRankEvaluatorTest {
    @Test
    void shouldBeAbleToReturnSingletonInstanceOfTheClass() {
        //arrange
        HandRankEvaluator handCategorizer1 = HandRankEvaluator.getInstance();
        HandRankEvaluator handCategorizer2 = HandRankEvaluator.getInstance();

        //act & assert
        assertEquals(handCategorizer1,handCategorizer2);
    }

    @Test
    void shouldBeAbleToIntializeTheInstanceOfHandRankEvaluatorClass() {
        // arrange
        HandRankEvaluator actual = new HandRankEvaluator();

        // act & assert
        assertNotNull(actual);
    }
    @Test
    void shouldBeAbleToReturnTheRankForHighCard() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ", "S3", "DJ", "H5", "C4");
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.HIGH_CARD;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForHighCardWithHighRankCard() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ", "S3", "DJ", "H5", "C4");
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.HIGH_CARD.withHighestCard(Rank.QUEEN);

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
}