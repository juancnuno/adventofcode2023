package com.juancnuno.adventofcode2023.day03.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day03.Part1;

public final class Part1Test {

    @Test
    public void getPartNumberSum() {
        // Arrange
        var schematic = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
            """;

        var part1 = new Part1(schematic.lines());

        // Act
        var sum = part1.getPartNumberSum();

        // Assert
        assertEquals(4_361, sum);
    }
}
