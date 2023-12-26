package com.juancnuno.adventofcode2023.day05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class Map {

    private final Collection<Ranges> collection = new ArrayList<>();
    private NavigableMap<Long, Long> map;

    public void add(Ranges ranges) {
        collection.add(ranges);
    }

    public void initInverse() {
        map = new TreeMap<>();
        map.put(0L, 0L);

        collection.stream()
                .sorted(Comparator.comparing(Ranges::getDestinationRangeStart))
                .forEach(ranges -> {
                    var start = ranges.getDestinationRangeStart();

                    map.put(start, ranges.getSourceRangeStart() - start);
                    map.put(start + ranges.getRangeLength(), 0L);
                });
    }

    public long get(long source) {
        return source + map.floorEntry(source).getValue();
    }
}
