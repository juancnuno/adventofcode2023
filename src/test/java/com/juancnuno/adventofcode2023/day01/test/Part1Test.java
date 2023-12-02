package com.juancnuno.adventofcode2023.day01.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day01.Part1;

public final class Part1Test {

    @Test
    public void getCalibrationValueSum() {
        // Act
        var sum = Part1.getCalibrationValueSum("""
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
            """);

        // Assert
        assertEquals(142, sum);
    }
}
