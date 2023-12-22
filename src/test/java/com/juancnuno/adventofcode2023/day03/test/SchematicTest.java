package com.juancnuno.adventofcode2023.day03.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day03.Schematic;

public final class SchematicTest {

    private static final String SCHEMATIC = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
            """;

    private final Schematic schematic = new Schematic(SCHEMATIC.lines());

    @Test
    public void getPartNumberSum() {
        // Act
        var sum = schematic.getPartNumberSum();

        // Assert
        assertEquals(4_361, sum);
    }

    @Test
    public void getGearRatioSum() {
        // Act
        var sum = schematic.getGearRatioSum();

        // Assert
        assertEquals(467_835, sum);
    }
}
