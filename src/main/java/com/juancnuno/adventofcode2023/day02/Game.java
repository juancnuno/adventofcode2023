package com.juancnuno.adventofcode2023.day02;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;

import com.juancnuno.adventofcode.Matcher;

public record Game(int id, Collection<Set> sets) {

    private static final Pattern PATTERN = Pattern.compile("Game (\\d+): (.+)");

    public static Game parse(String string) {
        var matcher = new Matcher(PATTERN, string);

        var sets = Arrays.stream(matcher.group(2).split("; "))
                .map(Set::parse)
                .toList();

        return new Game(matcher.intGroup(1), sets);
    }

    public boolean isPossible(Set set) {
        for (var s : sets) {
            if (!s.isPossible(set)) {
                return false;
            }
        }

        return true;
    }

    public Set getMinSet() {
        var redCubeCount = getMaxCount(Set::redCubeCount);
        var greenCubeCount = getMaxCount(Set::greenCubeCount);
        var blueCubeCount = getMaxCount(Set::blueCubeCount);

        return new Set(redCubeCount, greenCubeCount, blueCubeCount);
    }

    private int getMaxCount(ToIntFunction<Set> cubeCount) {
        return sets.stream()
                .mapToInt(cubeCount)
                .max()
                .orElseThrow();
    }
}
