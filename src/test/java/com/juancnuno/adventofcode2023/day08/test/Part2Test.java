package com.juancnuno.adventofcode2023.day08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day08.Part2;

public final class Part2Test {

    @Test
    public void getStepCount() {
        // Arrange
        var input = """
            LR

            11A = (11B, XXX)
            11B = (XXX, 11Z)
            11Z = (11B, XXX)
            22A = (22B, XXX)
            22B = (22C, 22C)
            22C = (22Z, 22Z)
            22Z = (22B, 22B)
            XXX = (XXX, XXX)
            """;

        var i = input.lines().iterator();

        // Act
        var count = Part2.getStepCount(i);

        // Assert
        assertEquals(6, count);
    }
}
