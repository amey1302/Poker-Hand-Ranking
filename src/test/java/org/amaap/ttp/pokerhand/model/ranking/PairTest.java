package org.amaap.ttp.pokerhand.model.ranking;

import org.amaap.ttp.pokerhand.model.builder.CardBuilder;
import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Hand;
import org.amaap.ttp.pokerhand.model.domain.HandRank;
import org.amaap.ttp.pokerhand.model.domain.HandRankEvaluator;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.amaap.ttp.pokerhand.model.ranking.Pair.isPair;
import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    CardBuilder cardBuilder = new CardBuilder();
    @Test
    void shouldBeAbleToReturnTheRankForPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForPair();

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
        List<Card> cards = cardBuilder.getCardsForPair();

        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.PAIR;

        // act
        boolean actual = isPair(hand);

        // assert
        assertTrue(actual);
    }

}