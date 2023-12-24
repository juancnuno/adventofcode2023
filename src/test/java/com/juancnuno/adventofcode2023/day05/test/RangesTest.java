package com.juancnuno.adventofcode2023.day05.test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.juancnuno.adventofcode2023.day05.Ranges;

public final class RangesTest {

    private static final Ranges RANGES = new Ranges("50 98 2");

    @Test
    public void get1() {
        // Act
        var destination = RANGES.get(98);

        // Assert
        assertEquals(50, destination);
    }

    @Test
    public void get2() {
        // Act
        var destination = RANGES.get(99);

        // Assert
        assertEquals(51, destination);
    }

    @Test
    public void get3() {
        // Act
        Executable get = () -> {
            RANGES.get(100);
        };

        // Assert
        var exception = assertThrows(NoSuchElementException.class, get);
        assertNull(exception.getMessage());
    }
}
