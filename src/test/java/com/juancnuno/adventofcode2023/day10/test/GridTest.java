package com.juancnuno.adventofcode2023.day10.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day10.Grid;

public final class GridTest {

    @Test
    public void getStepCount1() {
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
    public void getStepCount2() {
        // Arrange
        var grid = new Grid("""
            7-F7-
            .FJ|7
            SJLL7
            |F--J
            LJ.LJ
            """);

        // Act
        var count = grid.getStepCount();

        // Assert
        assertEquals(8, count);
    }

    @Test
    public void getEnclosedTileCount1() {
        // Arrange
        var grid = new Grid("""
            ...........
            .S-------7.
            .|F-----7|.
            .||.....||.
            .||.....||.
            .|L-7.F-J|.
            .|..|.|..|.
            .L--J.L--J.
            ...........
            """);

        // Act
        var count = grid.getEnclosedTileCount();

        // Assert
        assertEquals(4, count);
    }

    @Test
    public void getEnclosedTileCount2() {
        // Arrange
        var grid = new Grid("""
            ..........
            .S------7.
            .|F----7|.
            .||....||.
            .||....||.
            .|L-7F-J|.
            .|..||..|.
            .L--JL--J.
            ..........
            """);

        // Act
        var count = grid.getEnclosedTileCount();

        // Assert
        assertEquals(4, count);
    }

    @Test
    public void getEnclosedTileCount3() {
        // Arrange
        var grid = new Grid("""
            .F----7F7F7F7F-7....
            .|F--7||||||||FJ....
            .||.FJ||||||||L7....
            FJL7L7LJLJ||LJ.L-7..
            L--J.L7...LJS7F-7L7.
            ....F-J..F7FJ|L7L7L7
            ....L7.F7||L7|.L7L7|
            .....|FJLJ|FJ|F7|.LJ
            ....FJL-7.||.||||...
            ....L---J.LJ.LJLJ...
            """);

        // Act
        var count = grid.getEnclosedTileCount();

        // Assert
        assertEquals(8, count);
    }

    @Test
    public void getEnclosedTileCount4() {
        // Arrange
        var grid = new Grid("""
            FF7FSF7F7F7F7F7F---7
            L|LJ||||||||||||F--J
            FL-7LJLJ||||||LJL-77
            F--JF--7||LJLJ7F7FJ-
            L---JF-JLJ.||-FJLJJ7
            |F|F-JF---7F7-L7L|7|
            |FFJF7L7F-JF7|JL---7
            7-L-JL7||F7|L7F-7F7|
            L.L7LFJ|||||FJL7||LJ
            L7JLJL-JLJLJL--JLJ.L
            """);

        // Act
        var count = grid.getEnclosedTileCount();

        // Assert
        assertEquals(10, count);
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
