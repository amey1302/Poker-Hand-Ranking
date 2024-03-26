package org.amaap.ttp.pokerhand.model;

import org.amaap.ttp.pokerhand.model.domain.Card;
import org.amaap.ttp.pokerhand.model.domain.Rank;
import org.amaap.ttp.pokerhand.model.domain.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PokerManagerTest {
    PokerManager pokerManager = new PokerManager();
    @Test
    void shouldAbleToInitializePokerManagerToPerformOperations(){
        // assert
        assertNotNull(pokerManager);
    }
    @Test
    void shouldBeAbleToCreateASingleCard(){
        // arrange

        Suit suitType = Suit.C;
        Rank rank = Rank.EIGHT;
        Card expected = new Card(suitType,rank);
        System.out.println(expected);
        // act
        Card actual = pokerManager.createCard(suitType,rank);
        System.out.println(actual);
        // assert
        assertEquals(expected,actual);
    }
}
