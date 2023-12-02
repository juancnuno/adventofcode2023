package com.juancnuno.adventofcode2023.day02;

import java.util.regex.Pattern;

public record Set(int redCubeCount, int greenCubeCount, int blueCubeCount) {

    private static final Pattern PATTERN = Pattern.compile("(\\d+) \\w+");

    static Set parse(String string) {
        var counts = string.split(", ");

        var redCubeCount = 0;
        var greenCubeCount = 0;
        var blueCubeCount = 0;

        for (var count : counts) {
            if (count.endsWith("red")) {
                redCubeCount = parseCount(count);
            } else if (count.endsWith("green")) {
                greenCubeCount = parseCount(count);
            } else if (count.endsWith("blue")) {
                blueCubeCount = parseCount(count);
            } else {
                assert false;
            }
        }

        return new Set(redCubeCount, greenCubeCount, blueCubeCount);
    }

    private static int parseCount(String string) {
        var matcher = PATTERN.matcher(string);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(string);
        }

        return Integer.parseInt(matcher.group(1));
    }

    boolean isPossible(Set set) {
        return redCubeCount <= set.redCubeCount
                && greenCubeCount <= set.greenCubeCount
                && blueCubeCount <= set.blueCubeCount;
    }

    int getPower() {
        return redCubeCount * greenCubeCount * blueCubeCount;
    }
}
