package com.juancnuno.adventofcode2023.day09;

import java.util.stream.Stream;

public final class Part1 {

    private Part1() {
    }

    public static int getNextSum(Stream<String> histories) {
        return histories
                .map(History::new)
                .mapToInt(History::getNext)
                .sum();
    }
}
