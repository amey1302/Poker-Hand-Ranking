package org.amaap.ttp.pokerhand.model.domain;

import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void shouldAbleToCreateACardWithSuitAndRank() throws InvalidCardException {
        // arrange
        Suit suit = Suit.HEART;
        Rank rank = Rank.ACE;

        // act
        Card card = Card.create(suit,rank);

        //assert
        assertNotNull("HEART_ACE",card.toString());
    }

}