package org.amaap.ttp.pokerhandrankingpair.version1.domain;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Card;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.PokerManager;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Rank;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.Suit;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerManagerTest {

    @Test
    void shouldBeAbleToCreateASingleCard() throws InvalidCardException {
        // arrange
        Card expectedCard = Card.create(Suit.SPADE, Rank.ACE);

        // act
        PokerManager pokerManager = new PokerManager();
        Card actualCard = pokerManager.createCard(Suit.SPADE,Rank.ACE);

        // assert
        assertEquals(expectedCard,actualCard);
    }

}
