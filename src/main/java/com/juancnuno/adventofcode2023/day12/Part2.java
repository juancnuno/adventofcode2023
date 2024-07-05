package com.juancnuno.adventofcode2023.day12;

import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part2 {

    private Part2() {
    }

    public static int getArrangementCountSum(Stream<String> records) {
        return records
                .map(Record::from)
                .map(Record::unfold)
                .mapToInt(Record::getArrangementCount)
                .sum();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(Part2::getArrangementCountSum);
    }
}
