package com.juancnuno.adventofcode2023.day10.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day10.Grid;

public final class GridTest {

    @Test
    public void testToString() {
        // Arrange
        var rows = """
            .....
            .F-7.
            .|.|.
            .L-J.
            .....
            """;

        var grid = new Grid(rows);

        // Act
        var string = grid.toString();

        // Assert
        assertEquals(rows, string);
    }
}
