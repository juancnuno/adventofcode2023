package com.juancnuno.adventofcode2023.day05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class Part2Seeds extends Seeds {

    private final NavigableMap<Long, Integer> map;

    public Part2Seeds(long[] longs) {
        var endpoints = new ArrayList<Endpoint>();

        for (int i = 0; i < longs.length; i += 2) {
            var value = longs[i];

            endpoints.add(new Endpoint(value, Endpoint.Type.LOWER));
            endpoints.add(new Endpoint(value + longs[i + 1], Endpoint.Type.UPPER));
        }

        endpoints.sort(null);

        map = new TreeMap<>();
        map.put(0L, 0);

        int count = 0;

        for (var endpoint : endpoints) {
            count += endpoint.type.adjustment;
            map.put(endpoint.value, count);
        }
    }

    private static final class Endpoint implements Comparable<Endpoint> {

        private static final Comparator<Endpoint> comparator = Comparator.<Endpoint>comparingLong(endpoint -> endpoint.value)
                .thenComparing(endpoint -> endpoint.type);

        private final long value;
        private final Type type;

        private Endpoint(long value, Type type) {
            this.value = value;
            this.type = type;
        }

        private enum Type {
            LOWER(1), UPPER(-1);

            private final int adjustment;

            private Type(int adjustment) {
                this.adjustment = adjustment;
            }
        }

        @Override
        public int compareTo(Endpoint endpoint) {
            return comparator.compare(this, endpoint);
        }
    }

    @Override
    public boolean contains(long seed) {
        return map.floorEntry(seed).getValue() != 0;
    }
}
