package com.juancnuno.adventofcode2023.day10.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day10.Grid;

public final class GridTest {

    @Test
    public void getStepCount() {
        // Arrange
        var grid = new Grid("""
            -L|F7
            7S-7|
            L|7||
            -L-J|
            L|-JF
            """);

        // Act
        var count = grid.getStepCount();

        // Assert
        assertEquals(4, count);
    }

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
