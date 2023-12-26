package com.juancnuno.adventofcode2023.day06.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day06.Part2;

public final class Part2Test {

    @Test
    public void getWinCount() {
        // Arrange
        var race = """
            Time:      7  15   30
            Distance:  9  40  200
            """;

        // Act
        var count = Part2.getWinCount(race);

        // Assert
        assertEquals(71_503, count);
    }
}
