package org.amaap.ttp.pokerhand.model;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Rank;
import org.amaap.ttp.pokerhand.model.domain.Suit;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidSuitException;
import org.junit.jupiter.api.Test;

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

        assertEquals(expectedExceptionMessage,exception.getMessage() );
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
        assertEquals(expectedExceptionMessage,exception.getMessage());
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
}

