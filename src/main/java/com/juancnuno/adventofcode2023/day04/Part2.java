package com.juancnuno.adventofcode2023.day04;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part2 {

    private Part2() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(scratchcards -> new Table(scratchcards).process());
    }
}
