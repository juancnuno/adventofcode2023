package com.juancnuno.adventofcode2023.day07.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day07.Part1;

public final class Part1Test {

    @Test
    public void getTotalWinnings() {
        // Arrange
        var string = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
            """;

        var stream = string.lines();

        // Act
        var winnings = Part1.getTotalWinnings(stream);

        // Assert
        assertEquals(6_440, winnings);
    }
}
