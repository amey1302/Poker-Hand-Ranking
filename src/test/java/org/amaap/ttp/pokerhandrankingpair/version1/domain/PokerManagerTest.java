package org.amaap.ttp.pokerhandrankingpair.version1.domain;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.*;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerManagerTest {
    PokerManager pokerManager = PokerManager.getInstance();


    @Test
    void shouldBeAbleToCreateASingleCard() throws InvalidCardException {
        // arrange
        Card expectedCard = Card.create(Suit.SPADE, Rank.ACE);

        // act
        Card actualCard = pokerManager.createCard(Suit.SPADE,Rank.ACE);

        // assert
        assertEquals(expectedCard,actualCard);
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
        Hand hand = pokerManager.createHand(symbols);
        List<Card> actualCards = hand.getCards();

        // assert
        assertEquals(expectedCards, actualCards);
    }
    @Test
    void shouldBeAbleToEvaluateHandAndReturnItsRanking() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("H4", "S5", "D6", "H7", "C8");
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT;

        // act
        HandRank actual = pokerManager.evaluateHandRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
}
