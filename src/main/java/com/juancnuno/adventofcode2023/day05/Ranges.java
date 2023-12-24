package com.juancnuno.adventofcode2023.day05;

import java.util.NoSuchElementException;

public final class Ranges {

    private final long sourceRangeStart;
    private final long destinationRangeStart;
    private final int rangeLength;

    public Ranges(String ranges) {
        var array = ranges.split(" ");

        sourceRangeStart = Long.parseLong(array[1]);
        destinationRangeStart = Long.parseLong(array[0]);
        rangeLength = Integer.parseInt(array[2]);
    }

    public long get(long source) {
        if (!containsSource(source)) {
            throw new NoSuchElementException();
        }

        return destinationRangeStart + source - sourceRangeStart;
    }

    boolean containsSource(long source) {
        return sourceRangeStart <= source && source < sourceRangeStart + rangeLength;
    }
}
