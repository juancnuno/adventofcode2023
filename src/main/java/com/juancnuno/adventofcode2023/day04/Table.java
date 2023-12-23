package com.juancnuno.adventofcode2023.day04;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Table {

    private final List<Scratchcard> scratchcards;
    private final Map<Scratchcard, Integer> scratchcardToCountMap;

    public Table(Stream<String> scratchcards) {
        this.scratchcards = scratchcards
                .map(Scratchcard::parse)
                .toList();

        scratchcardToCountMap = this.scratchcards.stream().collect(Collectors.toMap(scratchcard -> scratchcard, scratchcard -> 1));
    }

    public int process() {
        for (int i = 0, size = scratchcards.size(); i < size; i++) {
            var scratchcard = scratchcards.get(i);

            for (int j = 0, count = scratchcardToCountMap.get(scratchcard); j < count; j++) {
                scratchcards.subList(i + 1, i + 1 + scratchcard.getWinningNumberCount()).forEach(this::incrementCount);
            }
        }

        return scratchcardToCountMap.values().stream()
                .mapToInt(count -> count)
                .sum();
    }

    private void incrementCount(Scratchcard scratchcard) {
        scratchcardToCountMap.compute(scratchcard, (s, count) -> count + 1);
    }
}
