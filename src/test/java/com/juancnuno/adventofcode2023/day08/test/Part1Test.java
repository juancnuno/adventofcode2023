package com.juancnuno.adventofcode2023.day08.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day08.Part1;

public final class Part1Test {

    @Test
    public void getStepCount1() {
        // Arrange
        var input = """
            RL

            AAA = (BBB, CCC)
            BBB = (DDD, EEE)
            CCC = (ZZZ, GGG)
            DDD = (DDD, DDD)
            EEE = (EEE, EEE)
            GGG = (GGG, GGG)
            ZZZ = (ZZZ, ZZZ)
            """;

        var i = input.lines().iterator();

        // Act
        var count = Part1.getStepCount(i);

        // Assert
        assertEquals(2, count);
    }

    @Test
    public void getStepCount2() {
        // Arrange
        var input = """
            LLR

            AAA = (BBB, BBB)
            BBB = (AAA, ZZZ)
            ZZZ = (ZZZ, ZZZ)
            """;

        var i = input.lines().iterator();

        // Act
        var count = Part1.getStepCount(i);

        // Assert
        assertEquals(6, count);
    }
}
