package com.juancnuno.adventofcode2023.day06.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day06.Part1;

public final class Part1Test {

    @Test
    public void getWinCountProduct() {
        // Arrange
        var races = """
            Time:      7  15   30
            Distance:  9  40  200
            """;

        // Act
        var product = Part1.getWinCountProduct(races);

        // Assert
        assertEquals(288, product);
    }
}
