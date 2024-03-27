package org.amaap.ttp.pokerhand.model.domain.validator;

import org.amaap.ttp.pokerhand.model.builder.CardBuilder;
import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Rank;
import org.amaap.ttp.pokerhand.model.domain.Suit;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.amaap.ttp.pokerhand.model.domain.validator.HandValidator.isInvalidHandCapacity;
import static org.amaap.ttp.pokerhand.model.domain.validator.HandValidator.isValidHandCapacity;
import static org.junit.jupiter.api.Assertions.*;

class HandValidatorTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleReturnTrueWhenHandCapacityIsFive() throws InvalidCardException {
        // arrange
        List<Card> cards = cardBuilder.getRandomCards();

        // act
        boolean isValid = isValidHandCapacity(cards);

        // assert
        assertTrue(isValid);
    }
    @Test
    void shouldBeAbleReturnFalseWhenHandCapacityIsSix() throws InvalidCardException {
        // arrange
        List<Card> cards = cardBuilder.getRandomCards();
        cards.add(Card.create(Suit.HEART, Rank.ACE));

        // act
        boolean isInvalid = isInvalidHandCapacity(cards);

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
        boolean isInvalid = isInvalidHandCapacity(cards);

        // assert
        assertTrue(isInvalid);
    }

}