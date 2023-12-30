package com.juancnuno.adventofcode2023.day08;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part2 {

    private Part2() {
    }

    public static long getStepCount(Iterator<String> i) {
        var instructions = i.next();
        i.next();

        var ghosts = new Network(i).getMap().entrySet().stream()
                .filter(entry -> entry.getKey().endsWith("A"))
                .map(Entry::getValue)
                .map(start -> new Ghost(start, new Instructions(instructions)))
                .toList();

        var counts = ghosts.stream()
                .mapToLong(Ghost::getStepCount)
                .toArray();

        return lcm(counts);
    }

    private static long lcm(long[] longs) {
        return Arrays.stream(longs).reduce(1, Part2::lcm);
    }

    private static long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }

    private static long gcd(long x, long y) {
        while (y != 0) {
            var tmp = y;
            y = x % y;
            x = tmp;
        }

        return x;
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(stream -> getStepCount(stream.iterator()));
    }
}
