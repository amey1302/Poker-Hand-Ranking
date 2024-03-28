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

import static org.junit.jupiter.api.Assertions.*;

class RoyalFlushTest {
    CardBuilder cardBuilder = new CardBuilder();
    @Test
    void shouldBeAbleToReturnTheRankForRoyalFlush() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCardsForRoyalFlush();
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.ROYAL_FLUSH;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }


}