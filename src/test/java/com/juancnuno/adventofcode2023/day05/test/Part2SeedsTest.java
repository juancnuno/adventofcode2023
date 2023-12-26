package com.juancnuno.adventofcode2023.day05.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day05.Part2Seeds;
import com.juancnuno.adventofcode2023.day05.Seeds;

public final class Part2SeedsTest {

    private final Seeds seeds = new Part2Seeds(new long[]{1, 3, 3, 2});

    @Test
    public void contains1() {
        // Act
        var contains = seeds.contains(0);

        // Assert
        assertFalse(contains);
    }

    @Test
    public void contains2() {
        // Act
        var contains = seeds.contains(1);

        // Assert
        assertTrue(contains);
    }

    @Test
    public void contains3() {
        // Act
        var contains = seeds.contains(3);

        // Assert
        assertTrue(contains);
    }

    @Test
    public void contains4() {
        // Act
        var contains = seeds.contains(5);

        // Assert
        assertFalse(contains);
    }
}
