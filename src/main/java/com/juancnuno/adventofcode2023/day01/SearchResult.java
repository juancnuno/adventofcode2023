package com.juancnuno.adventofcode2023.day01;

import java.util.Comparator;
import java.util.Map;
import static java.util.Map.entry;

public final class SearchResult implements Comparable<SearchResult> {

    private static final Map<String, Integer> NAME_TO_VALUE_MAP = Map.ofEntries(
            entry("1", 1),
            entry("2", 2),
            entry("3", 3),
            entry("4", 4),
            entry("5", 5),
            entry("6", 6),
            entry("7", 7),
            entry("8", 8),
            entry("9", 9),
            entry("one", 1),
            entry("two", 2),
            entry("three", 3),
            entry("four", 4),
            entry("five", 5),
            entry("six", 6),
            entry("seven", 7),
            entry("eight", 8),
            entry("nine", 9));

    public static int getFirstDigit(String line) {
        return NAME_TO_VALUE_MAP.keySet().stream()
                .map(name -> new SearchResult(line.indexOf(name), name))
                .filter(SearchResult::hasMatch)
                .min(Comparator.naturalOrder())
                .orElseThrow()
                .getDigit();
    }

    public static int getLastDigit(String line) {
        return NAME_TO_VALUE_MAP.keySet().stream()
                .map(name -> new SearchResult(line.lastIndexOf(name), name))
                .filter(SearchResult::hasMatch)
                .max(Comparator.naturalOrder())
                .orElseThrow()
                .getDigit();
    }

    private final int index;
    private final String digit;

    private SearchResult(int index, String digit) {
        this.index = index;
        this.digit = digit;
    }

    private boolean hasMatch() {
        return index != -1;
    }

    private int getDigit() {
        return NAME_TO_VALUE_MAP.get(digit);
    }

    @Override
    public int compareTo(SearchResult result) {
        return Integer.compare(index, result.index);
    }
}
