package org.amaap.ttp.pokerhand.model.domain;

import org.amaap.ttp.pokerhand.model.builder.CardBuilder;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HandTest {
    CardBuilder cardBuilder = new CardBuilder();

    @Test
    void shouldBeAbleToCreateHandWhenFiveCardArePassed() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCards();

        // act
        Hand actual = Hand.create(cards);

        // assert
        assertEquals(cards, actual.getCards());

    }

    @Test
    void shouldBeAbleToThrowInvalidHandCapacityExceptionWhenHandCapacityIsInvalid() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getCards();
        cards.add(Card.create(Suit.HEART, Rank.ACE));

        // act & assert
        assertThrows(InvalidHandCapacityException.class, () -> Hand.create(cards));
    }

    @Test
    void shouldBeAbleToThrowInvalidHandCapacityExceptionWhenHandCapacityIsNegative() {
        // act & assert
        assertThrows(InvalidHandCapacityException.class, () -> Hand.create(null));
    }

    @Test
    void shouldBeAbleGetStringRepresentationOfHand() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = cardBuilder.getRandomCards();
        Hand hand = Hand.create(cards);
        String expected = "[" + hand.getCards().stream()
                .map(card -> "\"" + card.getSuit().getAbbreviation() + card.getRank().getAbbreviation() + "\"")
                .collect(Collectors.joining(" ")) + "]";

        // act
        String actual = hand.getStringRepresentation();

        // assert
        assertEquals(expected, actual);
    }
}