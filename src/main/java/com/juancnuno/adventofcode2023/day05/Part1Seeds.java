package com.juancnuno.adventofcode2023.day05;

import java.util.Arrays;

public final class Part1Seeds extends Seeds {

    private final long[] seeds;

    public Part1Seeds(long[] seeds) {
        Arrays.sort(seeds);
        this.seeds = seeds;
    }

    @Override
    public boolean contains(long seed) {
        return Arrays.binarySearch(seeds, seed) >= 0;
    }
}
