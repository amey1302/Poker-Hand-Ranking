package org.amaap.ttp.pokerhand.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PokerManagerTest {
    @Test
    void shouldAbleToInitializePokerManagerToPerformOperations(){
        PokerManager pokerManager = new PokerManager();
        assertNotNull(pokerManager);
    }
}
