package com.juancnuno.adventofcode2023.day02;

import java.util.regex.Pattern;

import com.juancnuno.adventofcode.Matcher;

public record Set(int redCubeCount, int greenCubeCount, int blueCubeCount) {

    private static final Pattern PATTERN = Pattern.compile("(\\d+) \\w+");

    static Set parse(String string) {
        var counts = string.split(", ");

        var redCubeCount = 0;
        var greenCubeCount = 0;
        var blueCubeCount = 0;

        for (var count : counts) {
            if (count.endsWith("red")) {
                redCubeCount = new Matcher(PATTERN, count).intGroup(1);
            } else if (count.endsWith("green")) {
                greenCubeCount = new Matcher(PATTERN, count).intGroup(1);
            } else if (count.endsWith("blue")) {
                blueCubeCount = new Matcher(PATTERN, count).intGroup(1);
            } else {
                assert false;
            }
        }

        return new Set(redCubeCount, greenCubeCount, blueCubeCount);
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
