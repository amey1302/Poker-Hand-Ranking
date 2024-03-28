package org.amaap.ttp.pokerhand.domain.model;

import org.amaap.ttp.pokerhand.domain.model.exception.InvalidHandCapacityException;
import org.amaap.ttp.pokerhand.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Hand;
import org.amaap.ttp.pokerhand.domain.model.Rank;
import org.amaap.ttp.pokerhand.domain.model.Suit;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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