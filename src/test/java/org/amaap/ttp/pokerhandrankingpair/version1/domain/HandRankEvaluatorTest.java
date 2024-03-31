package org.amaap.ttp.pokerhandrankingpair.version1.domain;

import org.junit.jupiter.api.Test;

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
}