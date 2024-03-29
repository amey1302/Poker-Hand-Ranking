package org.amaap.ttp.pokerhand.domain.builder;

import org.amaap.ttp.pokerhand.domain.model.Card;
import org.amaap.ttp.pokerhand.domain.model.Suit;
import org.amaap.ttp.pokerhand.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhand.domain.model.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardBuilder {
    List<Card> cards = new ArrayList<>();
    List<String> stringList = new ArrayList<>();

    public List<Card> getCards() throws InvalidCardException {
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.HEART, Rank.THREE));
        cards.add(Card.create(Suit.DIAMOND, Rank.FOUR));
        cards.add(Card.create(Suit.SPADE, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        return cards;
    }

    public List<Card> getRandomCards() throws InvalidCardException {
        cards.add(Card.create(Suit.CLUB, Rank.EIGHT));
        cards.add(Card.create(Suit.DIAMOND, Rank.NINE));
        cards.add(Card.create(Suit.SPADE, Rank.JACK));
        cards.add(Card.create(Suit.HEART, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.KING));
        return cards;
    }
    public List<String> getRandom() throws InvalidCardException {
        Arrays.asList( "HA","H2","H3","H4","H5");
        return stringList;
    }

    public List<Card> getCardsForRoyalFlush() throws InvalidCardException {
        cards.add(Card.create(Suit.CLUB, Rank.TEN));
        cards.add(Card.create(Suit.CLUB, Rank.JACK));
        cards.add(Card.create(Suit.CLUB, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.KING));
        cards.add(Card.create(Suit.CLUB, Rank.ACE));
        return cards;
    }

    public List<Card> getCardsForStraightFlush() throws InvalidCardException {
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.CLUB, Rank.THREE));
        cards.add(Card.create(Suit.CLUB, Rank.FOUR));
        cards.add(Card.create(Suit.CLUB, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        return cards;
    }

    public List<Card> getCardsForFourOfAKind() throws InvalidCardException {
        cards.add(Card.create(Suit.HEART, Rank.ACE));
        cards.add(Card.create(Suit.CLUB, Rank.ACE));
        cards.add(Card.create(Suit.SPADE, Rank.ACE));
        cards.add(Card.create(Suit.DIAMOND, Rank.ACE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        return cards;
    }

    public List<Card> getCardsForFullHouse() throws InvalidCardException {
        cards.add(Card.create(Suit.HEART, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.QUEEN));
        cards.add(Card.create(Suit.SPADE, Rank.QUEEN));
        cards.add(Card.create(Suit.DIAMOND, Rank.SIX));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        return cards;
    }

    public List<Card> getCardsForFlush() throws InvalidCardException {
        cards.add(Card.create(Suit.HEART, Rank.NINE));
        cards.add(Card.create(Suit.HEART, Rank.KING));
        cards.add(Card.create(Suit.HEART, Rank.JACK));
        cards.add(Card.create(Suit.HEART, Rank.SEVEN));
        cards.add(Card.create(Suit.HEART, Rank.SIX));
        return cards;
    }

    public List<Card> getCardsForStraight() throws InvalidCardException {
        cards.add(Card.create(Suit.HEART, Rank.THREE));
        cards.add(Card.create(Suit.CLUB, Rank.FOUR));
        cards.add(Card.create(Suit.SPADE, Rank.FIVE));
        cards.add(Card.create(Suit.DIAMOND, Rank.SIX));
        cards.add(Card.create(Suit.CLUB, Rank.SEVEN));
        return cards;
    }

    public List<Card> getCardsForThreeOfAKind() throws InvalidCardException {
        cards.add(Card.create(Suit.HEART, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.QUEEN));
        cards.add(Card.create(Suit.SPADE, Rank.QUEEN));
        cards.add(Card.create(Suit.DIAMOND, Rank.ACE));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        return cards;
    }

    public List<Card> getCardsForTwoPair() throws InvalidCardException {
        cards.add(Card.create(Suit.HEART, Rank.TWO));
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        cards.add(Card.create(Suit.SPADE, Rank.QUEEN));
        cards.add(Card.create(Suit.DIAMOND, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.FIVE));
        return cards;
    }

    public List<Card> getCardsForPair() throws InvalidCardException {
        cards.add(Card.create(Suit.HEART, Rank.QUEEN));
        cards.add(Card.create(Suit.CLUB, Rank.ACE));
        cards.add(Card.create(Suit.SPADE, Rank.NINE));
        cards.add(Card.create(Suit.DIAMOND, Rank.SIX));
        cards.add(Card.create(Suit.CLUB, Rank.SIX));
        return cards;
    }

    public List<Card> getCardsForHighCard() throws InvalidCardException {
        cards.add(Card.create(Suit.HEART, Rank.SEVEN));
        cards.add(Card.create(Suit.CLUB, Rank.NINE));
        cards.add(Card.create(Suit.SPADE, Rank.EIGHT));
        cards.add(Card.create(Suit.DIAMOND, Rank.FIVE));
        cards.add(Card.create(Suit.CLUB, Rank.TWO));
        return cards;
    }
}
