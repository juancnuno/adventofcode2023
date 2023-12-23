package com.juancnuno.adventofcode2023.day04;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Table {

    private final List<Scratchcard> scratchcards;
    private final Map<Scratchcard, Integer> scratchcardToCountMap;

    public Table(Stream<String> scratchcards) {
        this.scratchcards = scratchcards
                .map(Scratchcard::parse)
                .toList();

        scratchcardToCountMap = this.scratchcards.stream()
                .collect(Collectors.toMap(scratchcard -> scratchcard, scratchcard -> 1));
    }

    public int process() {
        IntStream.range(0, scratchcards.size()).forEach(i -> {
            var scratchcard = scratchcards.get(i);
            var s = scratchcards.subList(i + 1, i + 1 + scratchcard.getWinningNumberCount());

            copy(s, scratchcardToCountMap.get(scratchcard));
        });

        return scratchcardToCountMap.values().stream()
                .mapToInt(count -> count)
                .sum();
    }

    private void copy(Iterable<Scratchcard> scratchcards, int count) {
        IntStream.range(0, count).forEach(i -> scratchcards.forEach(this::incrementCount));
    }

    private void incrementCount(Scratchcard scratchcard) {
        scratchcardToCountMap.compute(scratchcard, (s, count) -> count + 1);
    }
}
