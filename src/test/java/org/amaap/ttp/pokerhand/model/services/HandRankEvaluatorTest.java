package org.amaap.ttp.pokerhand.model.services;

import org.amaap.ttp.pokerhand.model.domain.*;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.model.domain.exception.InvalidHandCapacityException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandRankEvaluatorTest {
    @Test
    void shouldBeAbleToReturnTheRankForRoyalFlush() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.CLUB, Rank.TEN));
        cards.add(Card.create(Suit.CLUB, Rank.JACK));
        cards.add(Card.create(Suit.CLUB, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.KING));
        cards.add(Card.create(Suit.CLUB, Rank.ACE));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.ROYAL_FLUSH;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForStraightFlush() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.CLUB, Rank.THREE));
        cards.add(Card.create(Suit.CLUB, Rank.FOUR));
        cards.add(Card.create(Suit.CLUB, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT_FLUSH;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForFourOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.ACE));
        cards.add(Card.create(Suit.CLUB, Rank.ACE));
        cards.add(Card.create(Suit.SPADE, Rank.ACE));
        cards.add(Card.create(Suit.DIAMOND, Rank.ACE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.FOUR_OF_A_KIND;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForFullHouse() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.QUEEN));
        cards.add(Card.create(Suit.SPADE, Rank.QUEEN));
        cards.add(Card.create(Suit.DIAMOND, Rank.SIX));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.FULL_HOUSE;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForFLUSH() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.NINE));
        cards.add(Card.create(Suit.HEART, Rank.KING));
        cards.add(Card.create(Suit.HEART, Rank.JACK));
        cards.add(Card.create(Suit.HEART, Rank.SEVEN));
        cards.add(Card.create(Suit.HEART, Rank.SIX));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.FLUSH;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForStraight() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.THREE));
        cards.add(Card.create(Suit.CLUB, Rank.FOUR));
        cards.add(Card.create(Suit.SPADE, Rank.FIVE));
        cards.add(Card.create(Suit.DIAMOND, Rank.SIX));
        cards.add(Card.create(Suit.CLUB, Rank.SEVEN));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.STRAIGHT;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForThreeOfAKind() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.QUEEN));
        cards.add(Card.create(Suit.SPADE, Rank.QUEEN));
        cards.add(Card.create(Suit.DIAMOND, Rank.ACE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.THREE_OF_A_KIND;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForTwoPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.TWO));
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.SPADE, Rank.QUEEN));
        cards.add(Card.create(Suit.DIAMOND, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.FIVE));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.TWO_PAIR;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForPair() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.ACE));
        cards.add(Card.create(Suit.SPADE, Rank.NINE));
        cards.add(Card.create(Suit.DIAMOND, Rank.SIX));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.PAIR;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheRankForHighCard() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.SEVEN));
        cards.add(Card.create(Suit.CLUB, Rank.NINE));
        cards.add(Card.create(Suit.SPADE, Rank.EIGHT));
        cards.add(Card.create(Suit.DIAMOND, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.HIGH_CARD;

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void shouldBeAbleToReturnTheRankForHighCardWithHighRankCard() throws InvalidCardException, InvalidHandCapacityException {
        // arrange
        List<Card> cards = new ArrayList<>();
        cards.add(Card.create(Suit.HEART, Rank.SEVEN));
        cards.add(Card.create(Suit.CLUB, Rank.NINE));
        cards.add(Card.create(Suit.SPADE, Rank.EIGHT));
        cards.add(Card.create(Suit.DIAMOND, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        Hand hand = Hand.create(cards);
        HandRank expected = HandRank.HIGH_CARD.withHighestCard(Rank.NINE);

        // act
        HandRank actual = HandRankEvaluator.evaluateRanking(hand);

        // assert
        assertEquals(expected, actual);
    }
}