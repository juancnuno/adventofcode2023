package com.juancnuno.adventofcode2023.day11.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day11.Galaxy;

public final class GalaxyTest {

    @Test
    public void distance1() {
        // Arrange
        var galaxy5 = new Galaxy(6, 1);
        var galaxy9 = new Galaxy(11, 5);

        // Act
        var distance = galaxy5.distance(galaxy9);

        // Assert
        assertEquals(9, distance);
    }

    @Test
    public void distance2() {
        // Arrange
        var galaxy1 = new Galaxy(0, 4);
        var galaxy7 = new Galaxy(10, 9);

        // Act
        var distance = galaxy1.distance(galaxy7);

        // Assert
        assertEquals(15, distance);
    }

    @Test
    public void distance3() {
        // Arrange
        var galaxy3 = new Galaxy(2, 0);
        var galaxy6 = new Galaxy(7, 12);

        // Act
        var distance = galaxy3.distance(galaxy6);

        // Assert
        assertEquals(17, distance);
    }
}
