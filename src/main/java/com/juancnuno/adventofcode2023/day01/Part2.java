package com.juancnuno.adventofcode2023.day01;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part2 {

    private Part2() {
    }

    public static int getCalibrationValueSum(String lines) {
        return lines.lines()
                .mapToInt(Part2::getCalibrationValue)
                .sum();
    }

    private static int getCalibrationValue(String line) {
        return SearchResult.getFirstDigit(line) * 10 + SearchResult.getLastDigit(line);
    }

    public static void main(String[] args) {
        AdventOfCode.printResultString(Part2::getCalibrationValueSum);
    }
}
