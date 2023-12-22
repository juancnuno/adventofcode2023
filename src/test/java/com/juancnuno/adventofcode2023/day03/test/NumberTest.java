package com.juancnuno.adventofcode2023.day03.test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day03.Number;
import com.juancnuno.adventofcode2023.day03.Point;

public final class NumberTest {

    private static final Number NUMBER = new Number(new Point(0, 0), 467);

    @Test
    public void getAdjacentLocations() {
        // Act
        var actualLocations = NUMBER.getAdjacentLocations();

        // Assert
        var expectedLocations = Set.of(
                new Point(-1, -1),
                new Point(-1, 0),
                new Point(-1, 1),
                new Point(-1, 2),
                new Point(-1, 3),
                new Point(0, -1),
                new Point(0, 3),
                new Point(1, -1),
                new Point(1, 0),
                new Point(1, 1),
                new Point(1, 2),
                new Point(1, 3));

        assertEquals(expectedLocations, actualLocations);
    }

    @Test
    public void getValueLength() {
        // Act
        var length = NUMBER.getValueLength();

        // Assert
        assertEquals(3, length);
    }
}
