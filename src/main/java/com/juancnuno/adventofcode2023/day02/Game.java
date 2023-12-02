package com.juancnuno.adventofcode2023.day02;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;

public record Game(int id, Collection<Set> sets) {

    private static final Pattern PATTERN = Pattern.compile("Game (\\d+): (.+)");

    public static Game parse(String string) {
        var matcher = PATTERN.matcher(string);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(string);
        }

        var sets = Arrays.stream(matcher.group(2).split("; "))
                .map(Set::parse)
                .toList();

        return new Game(Integer.parseInt(matcher.group(1)), sets);
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
