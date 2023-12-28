package com.juancnuno.adventofcode2023.day07;

import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.juancnuno.adventofcode.Matcher;

public final class Hands {

    private static final Pattern PATTERN = Pattern.compile("(\\w+) (\\d+)");

    private Hands() {
    }

    public static int getTotalWinnings(Stream<String> lines, Rule rule) {
        var map = new TreeMap<Hand, Integer>();

        lines.forEach(line -> {
            var matcher = new Matcher(PATTERN, line);
            map.put(Hand.parse(matcher.group(1), rule), matcher.intGroup(2));
        });

        int winnings = 0;
        int rank = 1;

        for (var hand : map.keySet()) {
            winnings += map.get(hand) * rank++;
        }

        return winnings;
    }
}
