package com.juancnuno.adventofcode2023.day05;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part2 {

    private Part2() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(almanac -> new Almanac(almanac, Part2Seeds::new).getLowestLocation());
    }
}
