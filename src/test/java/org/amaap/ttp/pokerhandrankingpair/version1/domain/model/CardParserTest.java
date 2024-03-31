package org.amaap.ttp.pokerhandrankingpair.version1.domain.model;

import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidCardRankException;
import org.amaap.ttp.pokerhandrankingpair.version1.domain.model.exception.InvalidSuitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardParserTest {

    CardParser cardParser = new CardParser();
    @Test
    void shouldBeAbleToThrowInvalidCardRankExceptionForInvalidCardRank(){
        // arrange
        String invalidSymbol = "S#";

        // act & assert
        assertThrows(InvalidCardRankException.class, () -> cardParser.parseCard(invalidSymbol));
    }
    @Test
    void shouldBeAbleToThrowInvalidCardSuitExceptionForInvalidCardSuit(){
        // arrange
        String invalidSymbol = "#A";

        // act & assert
        assertThrows(InvalidSuitException.class, () -> cardParser.parseCard(invalidSymbol));
    }
    @Test
    void shouldBeAbleToThrowInvalidCardExceptionForCardSymbolContainsMoreThan2Characters(){
        // arrange
        String invalidSymbol = "SSF";

        // act & assert
        assertThrows(InvalidCardException.class, () -> cardParser.parseCard(invalidSymbol));
    }
    @Test
    void shouldBeAbleToThrowInvalidCardExceptionWhenSymbolLengthIsNot2(){
        // arrange
        String invalidSymbol = "A";

        // act & assert
        assertThrows(InvalidCardException.class, () -> cardParser.parseCard(invalidSymbol));
    }
}