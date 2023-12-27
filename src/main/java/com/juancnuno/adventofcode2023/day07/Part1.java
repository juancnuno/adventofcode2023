package com.juancnuno.adventofcode2023.day07;

import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;
import com.juancnuno.adventofcode.Matcher;

public final class Part1 {

    private static final Pattern PATTERN = Pattern.compile("(\\w+) (\\d+)");

    private Part1() {
    }

    public static int getTotalWinnings(Stream<String> lines) {
        var map = new TreeMap<Hand, Integer>();

        lines.forEach(line -> {
            var matcher = new Matcher(PATTERN, line);
            map.put(Hand.parse(matcher.group(1)), matcher.intGroup(2));
        });

        int winnings = 0;
        int rank = 1;

        for (var hand : map.keySet()) {
            winnings += map.get(hand) * rank++;
        }

        return winnings;
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(Part1::getTotalWinnings);
    }
}
