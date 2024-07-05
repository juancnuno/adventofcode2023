package com.juancnuno.adventofcode2023.day11;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part2 {

    private Part2() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultString(rows -> Universe.valueOf(rows).getDistanceSum(1_000_000));
    }
}
