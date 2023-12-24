package com.juancnuno.adventofcode2023.day05;

import java.util.ArrayList;
import java.util.Collection;

public final class Map {

    private final Collection<Ranges> rangesCollection = new ArrayList<>();

    public void add(Ranges ranges) {
        rangesCollection.add(ranges);
    }

    public long get(long source) {
        return rangesCollection.stream()
                .filter(ranges -> ranges.containsSource(source))
                .mapToLong(ranges -> ranges.get(source))
                .findFirst()
                .orElse(source);
    }
}
