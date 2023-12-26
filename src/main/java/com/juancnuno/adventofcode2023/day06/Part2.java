package com.juancnuno.adventofcode2023.day06;

import java.util.regex.Pattern;

import com.juancnuno.adventofcode.AdventOfCode;
import com.juancnuno.adventofcode.Matcher;

public final class Part2 {

    private static final String INTS = "((?: *\\d+)+)";

    private static final Pattern TIME = Pattern.compile("Time: +" + INTS);
    private static final Pattern DISTANCE = Pattern.compile("Distance: +" + INTS);

    private Part2() {
    }

    public static int getWinCount(String race) {
        var lines = race.lines().iterator();

        var time = Integer.parseInt(new Matcher(TIME, lines.next()).group(1).replaceAll(" +", ""));
        var distance = Long.parseLong(new Matcher(DISTANCE, lines.next()).group(1).replaceAll(" +", ""));

        return new Race(time, distance).getWinCount();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultString(Part2::getWinCount);
    }
}
