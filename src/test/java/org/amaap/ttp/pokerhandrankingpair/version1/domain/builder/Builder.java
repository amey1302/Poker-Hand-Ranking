package org.amaap.ttp.pokerhandrankingpair.version1.domain.builder;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Rank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Suit;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    List<Card> cardList = new ArrayList<>();

    public List<Card> getCards() throws InvalidCardException {
        cardList.add(Card.create(Suit.SPADE, Rank.TWO));
        cardList.add(Card.create(Suit.DIAMOND, Rank.FIVE));
        cardList.add(Card.create(Suit.CLUB, Rank.SEVEN));
        cardList.add(Card.create(Suit.SPADE, Rank.TEN));
        cardList.add(Card.create(Suit.HEART, Rank.ACE));
        return cardList;
    }
}
