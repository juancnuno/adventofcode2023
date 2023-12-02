package com.juancnuno.adventofcode2023.day02.test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day02.Game;
import com.juancnuno.adventofcode2023.day02.Set;

public final class GameTest {

    @Test
    public void parse() {
        // Act
        var game = Game.parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");

        // Assert
        var sets = List.of(new Set(4, 0, 3), new Set(1, 2, 6), new Set(0, 2, 0));
        assertEquals(new Game(1, sets), game);
    }

    @Test
    public void isPossible() {
        // Arrange
        var game = Game.parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        var bag = new Set(12, 13, 14);

        // Act
        var possible = game.isPossible(bag);

        // Assert
        assertTrue(possible);
    }

    @Test
    public void getMinSet() {
        // Arrange
        var game = new Game(1, List.of(new Set(4, 0, 3), new Set(1, 2, 6), new Set(0, 2, 0)));

        // Act
        var set = game.getMinSet();

        // Assert
        assertEquals(new Set(4, 2, 6), set);
    }
}
