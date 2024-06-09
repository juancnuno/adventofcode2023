package com.juancnuno.adventofcode2023.day09;

import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part1 {

    private Part1() {
    }

    public static int getNextSum(Stream<String> histories) {
        return histories
                .map(History::new)
                .mapToInt(History::getNext)
                .sum();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(Part1::getNextSum);
    }
}
