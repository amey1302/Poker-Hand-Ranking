package org.amaap.ttp.pokerhandrankingpair.version1.domain.model.validator;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Rank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Suit;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidSuitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardValidatorTest {
    @Test
    void shouldBeAbleToIntializeTheInstanceOfCardValidator() {
        // arrange
        CardValidator actual = new CardValidator();

        // act & assert
        assertNotNull(actual);
    }

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
