package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardParserTest {

    @Test
    void shouldBeAbleToThrowInvalidCardExceptionForInvalidCardSymbol(){
        // arrange
        String invalidSymbol = "SS";

        // act & assert
        assertThrows(InvalidCardException.class, () -> CardParser.parseCard(invalidSymbol));
    }
    @Test
    void shouldBeAbleToThrowInvalidCardExceptionForCardSymbolContainsMoreThan2Characters(){
        // arrange
        String invalidSymbol = "SSF";

        // act & assert
        assertThrows(InvalidCardException.class, () -> CardParser.parseCard(invalidSymbol));
    }


}