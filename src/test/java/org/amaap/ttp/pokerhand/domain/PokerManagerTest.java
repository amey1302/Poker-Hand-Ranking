package org.amaap.ttp.pokerhand.domain;

import org.amaap.ttp.pokerhand.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhand.domain.model.*;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokerManagerTest {
    CardBuilder cardBuilder = new CardBuilder();
    PokerManager pokerManager = new PokerManager();

    @Test
    void shouldBeAbleToEvaluateHandAndReturnItsRanking() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("H3","H4","H5","H6","H7");
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT_FLUSH;

        // act
        HandRank actual = pokerManager.evaluateHandRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void shouldBeAbleToCreateHandFromSymbols() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> symbols = Arrays.asList("S2", "D5", "C7", "ST", "HA");
        List<Card> expectedCards = Arrays.asList(
                Card.create(Suit.SPADE, Rank.TWO),
                Card.create(Suit.DIAMOND, Rank.FIVE),
                Card.create(Suit.CLUB, Rank.SEVEN),
                Card.create(Suit.SPADE, Rank.TEN),
                Card.create(Suit.HEART, Rank.ACE)
        );

        // act
        Hand hand = pokerManager.createHandFromSymbols(symbols);
        List<Card> actualCards = hand.getCards();

        // assert
        assertEquals(expectedCards, actualCards);
    }
}

