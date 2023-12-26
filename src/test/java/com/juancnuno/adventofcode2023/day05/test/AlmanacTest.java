package com.juancnuno.adventofcode2023.day05.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day05.Almanac;
import com.juancnuno.adventofcode2023.day05.Part1Seeds;
import com.juancnuno.adventofcode2023.day05.Part2Seeds;

public final class AlmanacTest {

    private static final String ALMANAC = """
            seeds: 79 14 55 13

            seed-to-soil map:
            50 98 2
            52 50 48

            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15

            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4

            water-to-light map:
            88 18 7
            18 25 70

            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13

            temperature-to-humidity map:
            0 69 1
            1 0 69

            humidity-to-location map:
            60 56 37
            56 93 4
            """;

    @Test
    public void getLowestLocation1() {
        // Arrange
        var almanac = new Almanac(ALMANAC.lines(), Part1Seeds::new);

        // Act
        var location = almanac.getLowestLocation();

        // Assert
        assertEquals(35, location);
    }

    @Test
    public void getLowestLocation2() {
        // Arrange
        var almanac = new Almanac(ALMANAC.lines(), Part2Seeds::new);

        // Act
        var location = almanac.getLowestLocation();

        // Assert
        assertEquals(46, location);
    }
}
