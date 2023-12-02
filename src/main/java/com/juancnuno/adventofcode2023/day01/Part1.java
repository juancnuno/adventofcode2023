package com.juancnuno.adventofcode2023.day01;

import com.juancnuno.adventofcode.AdventOfCode;
import com.juancnuno.adventofcode.CharSequences;

public final class Part1 {

    private Part1() {
    }

    public static int getCalibrationValueSum(String lines) {
        return lines.lines()
                .mapToInt(Part1::getCalibrationValue)
                .sum();
    }

    private static int getCalibrationValue(CharSequence line) {
        var firstDigit = CharSequences.chars(line)
                .filter(Character::isDigit)
                .mapToInt(c -> c - '0')
                .findFirst()
                .orElseThrow();

        var lastDigit = CharSequences.chars(line)
                .filter(Character::isDigit)
                .mapToInt(c -> c - '0')
                .reduce((c1, c2) -> c2)
                .orElseThrow();

        return firstDigit * 10 + lastDigit;
    }

    public static void main(String[] args) {
        AdventOfCode.printResultString(Part1::getCalibrationValueSum);
    }
}
