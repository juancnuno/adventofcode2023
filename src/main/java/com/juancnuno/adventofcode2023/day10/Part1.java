package com.juancnuno.adventofcode2023.day10;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part1 {

    private Part1() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultString(rows -> new Grid(rows).getStepCount());
    }
}
