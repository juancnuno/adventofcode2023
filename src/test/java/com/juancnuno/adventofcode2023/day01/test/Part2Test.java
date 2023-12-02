package com.juancnuno.adventofcode2023.day01.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day01.Part2;

public final class Part2Test {

    @Test
    public void getCalibrationValueSum() {
        // Act
        var sum = Part2.getCalibrationValueSum("""
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
            """);

        // Assert
        assertEquals(281, sum);
    }
}
