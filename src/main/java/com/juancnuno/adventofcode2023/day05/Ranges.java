package com.juancnuno.adventofcode2023.day05;

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

    long getSourceRangeStart() {
        return sourceRangeStart;
    }

    long getDestinationRangeStart() {
        return destinationRangeStart;
    }

    int getRangeLength() {
        return rangeLength;
    }
}
