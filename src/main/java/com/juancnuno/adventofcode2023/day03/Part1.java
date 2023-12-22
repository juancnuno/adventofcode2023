package com.juancnuno.adventofcode2023.day03;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part1 {

    private Part1() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(lines -> new Schematic(lines).getPartNumberSum());
    }
}
