package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.builder.CardBuilder;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    CardBuilder builder = new CardBuilder();
    @Test
    void shouldBeAbleToCreateHandWhenFiveCardArePassed() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ", "S3", "DQ", "HA", "C3");
        List<String> expectedCardStrings = cards.stream()
                .map(card -> String.valueOf(card.charAt(0)) + String.valueOf(card.charAt(1)).toUpperCase())
                .collect(Collectors.toList());

        // act
        Hand actual = Hand.create(cards);
        List<String> actualCardStrings = actual.getCards().stream()
                .map(card -> card.getSuit().getKeyword() + card.getRank().getAbbreviation())
                .collect(Collectors.toList());

        // assert
        assertEquals(expectedCardStrings, actualCardStrings);

    }

    @Test
    void shouldBeAbleToThrowInvalidHandCapacityExceptionWhenHandCapacityIsInvalid() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> cards = Arrays.asList("HQ", "S3", "DQ", "HA", "C3","C7");

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
        List<String> cards = Arrays.asList("H3","H4","H5","H6","H7");
        Hand hand = Hand.create(cards);
        String expected = "[" + hand.getCards().stream()
                .map(card -> "\"" + card.getSuit().getKeyword() + card.getRank().getAbbreviation() + "\"")
                .collect(Collectors.joining("")) + "]";

        // act
        String actual = hand.getStringRepresentation();

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void shouldBeAbleToCreateHandFromSymbols() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<String> symbols = Arrays.asList("S2", "D5", "C7", "ST", "HA");
        List<Card> expectedCards = builder.getCards();

        // act
        Hand hand = Hand.create(symbols);
        List<Card> actualCards = hand.getCards();

        // assert
        assertEquals(expectedCards, actualCards);
    }

}