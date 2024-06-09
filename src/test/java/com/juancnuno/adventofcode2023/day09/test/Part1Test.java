package com.juancnuno.adventofcode2023.day09.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day09.Part1;

public final class Part1Test {

    @Test
    public void getNextSum() {
        // Arrange
        var histories = """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45
            """.lines();

        // Act
        var sum = Part1.getNextSum(histories);

        // Assert
        assertEquals(114, sum);
    }
}
