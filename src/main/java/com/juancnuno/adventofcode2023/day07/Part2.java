package com.juancnuno.adventofcode2023.day07;

import com.juancnuno.adventofcode.AdventOfCode;

final class Part2 {

    private Part2() {
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(lines -> Hands.getTotalWinnings(lines,
                JsAreJokers.INSTANCE));
    }
}
