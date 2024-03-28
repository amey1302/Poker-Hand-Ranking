package org.amaap.ttp.pokerhand.domain.validator;

import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Suit;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidSuitException;
import org.amaap.ttp.pokerhand.domain.model.Rank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CardValidatorTest {

    @Test
    void shouldBeAbleToThrowInvalidSuitExceptionWhenSuitIsNull() {
        // Arrange
        String expectedExceptionMessage = "The Suit is Invalid null";

        // Act & Assert
        Throwable exception = assertThrows(InvalidSuitException.class, () -> Card.create(null, Rank.TWO));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void shouldBeAbleToThrowInvalidCardRankExceptionWhenRankIsNull() {
        // Arrange
        String expectedExceptionMessage = "The Card Rank is Invalid null";

        // Act & Assert
        Throwable exception = assertThrows(InvalidCardRankException.class, () -> Card.create(Suit.HEART, null));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    @Test
    void shouldBeAbleToCreateValidCardWhenSuitAndRankAreValid() throws InvalidCardException {
        // Arrange & Act
        Card card = Card.create(Suit.HEART, Rank.TWO);

        // Assert
        assertEquals(Suit.HEART, card.getSuit());
        assertEquals(Rank.TWO, card.getRank());
    }

    @Test
    void shouldBeAbleToCreateValidCardWhenSuitAndRankAreValidForAce() throws InvalidCardException {
        // Arrange & Act
        Card card = Card.create(Suit.HEART, Rank.ACE);

        // Assert
        assertEquals(Suit.HEART, card.getSuit());
        assertEquals(Rank.ACE, card.getRank());
    }
}
