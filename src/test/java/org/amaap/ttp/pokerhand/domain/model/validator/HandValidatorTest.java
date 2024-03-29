package org.amaap.ttp.pokerhand.domain.model.validator;

import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Suit;
import org.amaap.ttp.pokerhand.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhand.domain.model.Rank;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.validator.HandValidator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandValidatorTest {
    CardBuilder cardBuilder = new CardBuilder();
    @Test
    void shouldBeAbleToIntializeTheInstanceOfHandValidatorClass() {
        // arrange
        HandValidator actual = new HandValidator();

        // act & assert
        assertNotNull(actual);
    }

    @Test
    void shouldBeAbleReturnTrueWhenHandCapacityIsFive() throws InvalidCardException {
        // arrange
        List<Card> cards = cardBuilder.getRandomCards();

        // act
        boolean isValid = HandValidator.isValidHandCapacity(cards);

        // assert
        assertTrue(isValid);
    }
    @Test
    void shouldBeAbleReturnFalseWhenHandCapacityIsSix() throws InvalidCardException {
        // arrange
        List<Card> cards = cardBuilder.getRandomCards();
        cards.add(Card.create(Suit.HEART, Rank.ACE));

        // act
        boolean isInvalid = HandValidator.isInvalidHandCapacity(cards);

        // assert
        assertTrue(isInvalid);
    }
    @Test
    void shouldBeAbleReturnFalseWhenHandCapacityIsTwo() throws InvalidCardException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.ACE));
        cards.add(Card.create(Suit.SPADE, Rank.TWO));

        // act
        boolean isInvalid = HandValidator.isInvalidHandCapacity(cards);

        // assert
        assertTrue(isInvalid);
    }

}