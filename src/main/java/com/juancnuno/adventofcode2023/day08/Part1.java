package com.juancnuno.adventofcode2023.day08;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part1 {

    private Part1() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(stream -> new Camel(stream.iterator()).getStepCount());
    }
}
