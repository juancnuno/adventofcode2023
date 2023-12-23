package com.juancnuno.adventofcode2023.day04;

import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part1 {

    private Part1() {
    }

    public static int getWorthSum(Stream<String> scratchcards) {
        return scratchcards
                .map(Scratchcard::parse)
                .mapToInt(Scratchcard::getWorth)
                .sum();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(Part1::getWorthSum);
    }
}
