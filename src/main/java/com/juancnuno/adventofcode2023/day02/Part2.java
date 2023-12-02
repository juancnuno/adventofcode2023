package com.juancnuno.adventofcode2023.day02;

import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part2 {

    private Part2() {
    }

    public static int getPowerSum(Stream<String> games) {
        return games
                .map(Game::parse)
                .map(Game::getMinSet)
                .mapToInt(Set::getPower)
                .sum();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(Part2::getPowerSum);
    }
}
