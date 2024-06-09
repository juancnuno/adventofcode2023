package com.juancnuno.adventofcode2023.day09;

import java.util.stream.Stream;

public final class Part2 {

    private Part2() {
    }

    public static int getPreviousSum(Stream<String> histories) {
        return histories
                .map(History::new)
                .mapToInt(History::getPrevious)
                .sum();
    }
}
