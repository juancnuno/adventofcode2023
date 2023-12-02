package com.juancnuno.adventofcode2023.day02;

import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part1 {

    private Part1() {
    }

    public static int getIdSum(Stream<String> games) {
        var bag = new Set(12, 13, 14);

        return games
                .map(Game::parse)
                .filter(game -> game.isPossible(bag))
                .mapToInt(Game::id)
                .sum();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(Part1::getIdSum);
    }
}
