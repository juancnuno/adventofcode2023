package com.juancnuno.adventofcode2023.day12;

import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part1 {

    private Part1() {
    }

    public static int getArrangementCountSum(Stream<String> records) {
        return records
                .map(Record::new)
                .mapToInt(Record::getArrangementCount)
                .sum();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(Part1::getArrangementCountSum);
    }
}
