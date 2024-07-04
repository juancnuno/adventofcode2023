package com.juancnuno.adventofcode2023.day11.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day11.Galaxy;

public final class GalaxyTest {

    @Test
    public void distance1() {
        // Arrange
        var galaxy1 = new Galaxy(6, 1);
        var galaxy2 = new Galaxy(11, 5);

        // Act
        var distance = galaxy1.distance(galaxy2);

        // Assert
        assertEquals(9, distance);
    }
}
