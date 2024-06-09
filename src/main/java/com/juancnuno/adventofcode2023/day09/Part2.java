package com.juancnuno.adventofcode2023.day09;

import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part2 {

    private Part2() {
    }

    public static int getPreviousSum(Stream<String> histories) {
        return histories
                .map(History::new)
                .mapToInt(History::getPrevious)
                .sum();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(Part2::getPreviousSum);
    }
}
