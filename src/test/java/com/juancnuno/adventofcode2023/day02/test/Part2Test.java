package com.juancnuno.adventofcode2023.day02.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day02.Part2;

public final class Part2Test {

    @Test
    public void getPowerSum() {
        var string = """
            Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
            Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
            Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
            Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
            """;

        var stream = string.lines();

        // Act
        var sum = Part2.getPowerSum(stream);

        // Assert
        assertEquals(2286, sum);
    }
}
