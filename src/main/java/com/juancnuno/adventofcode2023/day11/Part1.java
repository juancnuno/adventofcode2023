package com.juancnuno.adventofcode2023.day11;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part1 {

    private Part1() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultString(rows -> Universe.valueOf(rows).getDistanceSum());
    }
}
