package com.juancnuno.adventofcode2023.day05.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day05.Map;
import com.juancnuno.adventofcode2023.day05.Ranges;

public final class MapTest {

    private final Map map;

    public MapTest() {
        map = new Map();

        map.add(new Ranges("50 98 2"));
        map.add(new Ranges("52 50 48"));

        map.initInverse();
    }

    @Test
    public void get1() {
        // Act
        var destination = map.get(49);

        // Assert
        assertEquals(49, destination);
    }

    @Test
    public void get2() {
        // Act
        var destination = map.get(50);

        // Assert
        assertEquals(98, destination);
    }

    @Test
    public void get3() {
        // Act
        var destination = map.get(52);

        // Assert
        assertEquals(50, destination);
    }

    @Test
    public void get4() {
        // Act
        var destination = map.get(100);

        // Assert
        assertEquals(100, destination);
    }
}
