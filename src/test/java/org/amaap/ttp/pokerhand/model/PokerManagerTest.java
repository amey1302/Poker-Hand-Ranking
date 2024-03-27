package org.amaap.ttp.pokerhand.model;

import org.amaap.ttp.pokerhand.model.builder.CardBuilder;
import org.amaap.ttp.pokerhand.model.domain.*;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidSuitException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokerManagerTest {
    CardBuilder cardBuilder = new CardBuilder();
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
        Rank rank = Rank.ACE;

        // assert
        assertThrows(InvalidSuitException.class, () -> pokerManager.createCard(null, rank));

    }

    @Test
    void shouldBeAbleToThrowInvalidCardRankExceptionWhenCardRankIsInvalid() {
        // arrange & act
        Suit suit = Suit.CLUB;

        // assert
         assertThrows(InvalidCardRankException.class, () -> pokerManager.createCard(suit, null));
    }

    @Test
    void shouldBeAbleToThrowInvalidCardExceptionWhenCardInvalid() {
        // act & assert
        assertThrows(InvalidCardException.class, () -> pokerManager.createCard(null, null));
    }

    @Test
    void shouldBeAbleToAssignCardsToHand() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> expectedCards = cardBuilder.getRandomCards();

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
        List<Card> cards = cardBuilder.getCardsForStraightFlush();
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT_FLUSH;

        // act
        HandRank actual = pokerManager.evaluateHandRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
}

