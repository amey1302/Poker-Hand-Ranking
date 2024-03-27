package org.amaap.ttp.pokerhand.model.domain.validator;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Rank;
import org.amaap.ttp.pokerhand.model.domain.Suit;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidSuitException;
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
