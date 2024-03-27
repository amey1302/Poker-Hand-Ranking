package org.amaap.ttp.pokerhand.model.domain;

import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HandTest {
    @Test
    void shouldBeAbleToCreateHandWhenFiveCardArePassed() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.HEART, Rank.THREE));
        cards.add(Card.create(Suit.DIAMOND, Rank.FOUR));
        cards.add(Card.create(Suit.SPADE, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));

        // act
        Hand actual = Hand.create(cards);

        // assert
        assertEquals(cards, actual.getCards());

    }

    @Test
    void shouldBeAbleToThrowInvalidHandCapacityExceptionWhenHandCapacityIsInvalid() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.HEART, Rank.THREE));
        cards.add(Card.create(Suit.DIAMOND, Rank.FOUR));
        cards.add(Card.create(Suit.SPADE, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
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
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.CLUB, Rank.THREE));
        cards.add(Card.create(Suit.CLUB, Rank.FOUR));
        cards.add(Card.create(Suit.CLUB, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
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