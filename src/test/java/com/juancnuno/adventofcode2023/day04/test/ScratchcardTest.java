package com.juancnuno.adventofcode2023.day04.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day04.Scratchcard;

public final class ScratchcardTest {

    @Test
    public void getWorth1() {
        // Arrange
        var scratchcard = new Scratchcard("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53");

        // Act
        var worth = scratchcard.getWorth();

        // Asssert
        assertEquals(8, worth);
    }

    @Test
    public void getWorth2() {
        // Arrange
        var scratchcard = new Scratchcard("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19");

        // Act
        var worth = scratchcard.getWorth();

        // Asssert
        assertEquals(2, worth);
    }

    @Test
    public void getWorth3() {
        // Arrange
        var scratchcard = new Scratchcard("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1");

        // Act
        var worth = scratchcard.getWorth();

        // Asssert
        assertEquals(2, worth);
    }

    @Test
    public void getWorth4() {
        // Arrange
        var scratchcard = new Scratchcard("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83");

        // Act
        var worth = scratchcard.getWorth();

        // Asssert
        assertEquals(1, worth);
    }

    @Test
    public void getWorth5() {
        // Arrange
        var scratchcard = new Scratchcard("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36");

        // Act
        var worth = scratchcard.getWorth();

        // Asssert
        assertEquals(0, worth);
    }

    @Test
    public void getWorth6() {
        // Arrange
        var scratchcard = new Scratchcard("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11");

        // Act
        var worth = scratchcard.getWorth();

        // Asssert
        assertEquals(0, worth);
    }
}
