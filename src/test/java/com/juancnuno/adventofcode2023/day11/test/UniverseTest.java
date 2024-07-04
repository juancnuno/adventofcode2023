package com.juancnuno.adventofcode2023.day11.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day11.Universe;

public final class UniverseTest {

    @Test
    public void testToString() {
        // Arrange
        var rows = """
            ...#......
            .......#..
            #.........
            ..........
            ......#...
            .#........
            .........#
            ..........
            .......#..
            #...#.....
            """;

        var universe = new Universe(rows);

        // Act
        var string = universe.toString();

        // Assert
        assertEquals(rows, string);
    }
}
