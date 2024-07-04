package com.juancnuno.adventofcode2023.day10;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part2 {

    private Part2() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultString(rows -> new Grid(rows).getEnclosedTileCount());
    }
}
