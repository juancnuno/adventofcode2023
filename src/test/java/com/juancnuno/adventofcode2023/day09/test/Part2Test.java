package com.juancnuno.adventofcode2023.day09.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day09.Part2;

public final class Part2Test {

    @Test
    public void getPreviousSum() {
        // Arrange
        var histories = """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45
            """.lines();

        // Act
        var sum = Part2.getPreviousSum(histories);

        // Assert
        assertEquals(2, sum);
    }
}
