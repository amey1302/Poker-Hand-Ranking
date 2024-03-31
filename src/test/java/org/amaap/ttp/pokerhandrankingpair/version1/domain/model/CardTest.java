package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void shouldBeAbleToCreateACardWithSuitAndRank() throws InvalidCardException {
        // arrange
        Suit suit = Suit.HEART;
        Rank rank = Rank.ACE;

        // act
        Card card = Card.create(suit,rank);

        //assert
        assertNotNull("HEART_ACE",card.toString());
    }
    @Test
    void shouldBeAbleToTestHashCodeForTwoObjects() throws InvalidCardException {
        // arrange
        Card card1 = Card.create(Suit.HEART,Rank.ACE);
        Card card2 = Card.create(Suit.HEART,Rank.ACE);

        //assert
        assertEquals(card1.hashCode(),card2.hashCode());
    }
    @Test
    void shouldBeAbleToTestForEqualObjects() throws InvalidCardException {
        // arrange
        Card card1 = Card.create(Suit.CLUB,Rank.ACE);
        Card card2 = Card.create(Suit.CLUB,Rank.ACE);
        Card card3= Card.create(Suit.HEART,Rank.ACE);

        //assert
        assertTrue(card1.equals(card2));
        assertFalse(card2.equals(card3));
        assertFalse(card1.equals(null));
        assertFalse(card1.equals("someOtherObject"));
    }

}