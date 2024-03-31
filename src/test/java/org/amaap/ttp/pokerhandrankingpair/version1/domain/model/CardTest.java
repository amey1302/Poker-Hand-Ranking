package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidSuitException;
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
    void shouldBeAbleToThrowInvalidSuitExceptionWhenSuitIsInvalid() {
        // arrange & act
        Rank rank = Rank.ACE;

        // assert
        assertThrows(InvalidSuitException.class, () -> Card.create(null, rank));

    }

    @Test
    void shouldBeAbleToThrowInvalidCardRankExceptionWhenCardRankIsInvalid() {
        // arrange & act
        Suit suit = Suit.CLUB;

        // assert
        assertThrows(InvalidCardRankException.class, () -> Card.create(suit, null));
    }

    @Test
    void shouldBeAbleToThrowInvalidCardExceptionWhenCardInvalid() {
        // act & assert
        assertThrows(InvalidCardException.class, () -> Card.create(null, null));
    }
    @Test
    void shouldBeAbleToTestHashCodeForTwoObjects() throws InvalidCardException {
        // arrange
        Card card1 = Card.create(Suit.HEART,Rank.ACE);
        Card card2 = Card.create(Suit.HEART,Rank.ACE);

        // act & assert
        assertEquals(card1.hashCode(),card2.hashCode());
    }
    @Test
    void shouldBeAbleToTestForEqualObjects() throws InvalidCardException {
        // arrange
        Card card1 = Card.create(Suit.CLUB,Rank.ACE);
        Card card2 = Card.create(Suit.CLUB,Rank.ACE);
        Card card3= Card.create(Suit.HEART,Rank.ACE);

        //act & assert
        assertTrue(card1.equals(card2));
        assertFalse(card2.equals(card3));
        assertFalse(card1.equals(null));
        assertFalse(card1.equals("someOtherObject"));
    }
    @Test
    void shouldBeAbleToTestEqualityForTwoCardsWithSameSuitAndRank() throws InvalidCardException {
        // arrange
        Card card1 = Card.create(Suit.HEART, Rank.ACE);
        Card card2 = Card.create(Suit.HEART, Rank.ACE);

        // act & assert
        assertTrue(card1.equals(card2));
    }
    @Test
    void shouldBeAbleToTestEqualityForSameCard() throws InvalidCardException {
        // arrange
        Card card = Card.create(Suit.DIAMOND, Rank.KING);

        // act & assert
        assertTrue(card.equals(card));
    }

    @Test
    void shouldBeAbleToTestEqualityForCardWithDifferentObject() throws InvalidCardException {
        // arrange
        Card card = Card.create(Suit.DIAMOND, Rank.KING);

        // act & assert
        assertFalse(card.equals(new Object()));
    }

    @Test
    void shouldBeAbleToTestEqualityForCardWithNull() throws InvalidCardException {
        // arrange
        Card card = Card.create(Suit.DIAMOND, Rank.KING);

        // act & assert
        assertFalse(card.equals(null));
    }

    @Test
    void shouldBeAbleToTestEqualityForCardsWithDifferentSuit() throws InvalidCardException {
        // arrange
        Card card1 = Card.create(Suit.DIAMOND, Rank.KING);
        Card card2 = Card.create(Suit.SPADE, Rank.KING);

        // act & assert
        assertFalse(card1.equals(card2));
    }

    @Test
    void shouldBeAbleToTestEqualityForCardsWithDifferentRank() throws InvalidCardException {
        // arrange
        Card card1 = Card.create(Suit.DIAMOND, Rank.KING);
        Card card2 = Card.create(Suit.DIAMOND, Rank.QUEEN);

        // act & assert
        assertFalse(card1.equals(card2));
    }
}