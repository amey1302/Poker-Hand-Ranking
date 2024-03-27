package org.amaap.ttp.pokerhand.model;

import org.amaap.ttp.pokerhand.model.domain.*;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidSuitException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokerManagerTest {
    PokerManager pokerManager = new PokerManager();

    @Test
    void shouldAbleToInitializePokerManagerToPerformOperations() {
        // assert
        assertNotNull(pokerManager);
    }

    @Test
    void shouldBeAbleToCreateASingleCard() throws InvalidCardException {
        // arrange
        Suit suit = Suit.CLUB;
        Rank rank = Rank.EIGHT;
        Card expected = Card.create(suit, rank);

        // act
        Card actual = pokerManager.createCard(suit, rank);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowInvalidSuitExceptionWhenSuitIsInvalid() {
        // arrange & act
        Suit suit = null;
        Rank rank = Rank.ACE;
        String expectedExceptionMessage = "The Suit is Invalid " + suit;

        // assert
        Throwable exception = assertThrows(InvalidSuitException.class, () -> {
            pokerManager.createCard(suit, rank);
        });

        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void shouldBeAbleToThrowInvalidCardRankExceptionWhenCardRankIsInvalid() {
        // arrange & act
        Suit suit = Suit.CLUB;
        Rank rank = null;
        String expectedExceptionMessage = "The Card Rank is Invalid " + rank;

        // assert
        Throwable exception = assertThrows(InvalidCardRankException.class, () -> {
            pokerManager.createCard(suit, rank);
        });
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void shouldBeAbleToThrowInvalidCardExceptionWhenCardInvalid() {
        // arrange & act
        Suit suit = null;
        Rank rank = null;

        // assert
        assertThrows(InvalidCardException.class, () -> {
            pokerManager.createCard(suit, rank);
        });
    }

    @Test
    void shouldBeAbleToAssignCardsToHand() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(Card.create(Suit.CLUB, Rank.EIGHT));
        expectedCards.add(Card.create(Suit.DIAMOND, Rank.NINE));
        expectedCards.add(Card.create(Suit.SPADE, Rank.JACK));
        expectedCards.add(Card.create(Suit.HEART, Rank.QUEEN));
        expectedCards.add(Card.create(Suit.CLUB, Rank.KING));

        // act
        Hand hand = pokerManager.assignCardToHand(expectedCards);
        List<Card> actualCards = hand.getCards();

        // assert
        assertEquals(expectedCards.size(), actualCards.size());
        assertEquals(expectedCards, actualCards);
    }

    @Test
    void shouldBeAbleToEvaluateHandAndReturnItsRanking() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.CLUB, Rank.THREE));
        cards.add(Card.create(Suit.CLUB, Rank.FOUR));
        cards.add(Card.create(Suit.CLUB, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT_FLUSH;

        // act
        HandRank actual = pokerManager.evaluateHandRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
}

