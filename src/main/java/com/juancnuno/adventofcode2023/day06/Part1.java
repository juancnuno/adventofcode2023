package com.juancnuno.adventofcode2023.day06;

import java.util.regex.Pattern;

import com.juancnuno.adventofcode.AdventOfCode;
import com.juancnuno.adventofcode.Matcher;

public final class Part1 {

    private static final String INTS = "((?: *\\d+)+)";

    private static final Pattern TIMES = Pattern.compile("Time: +" + INTS);
    private static final Pattern DISTANCES = Pattern.compile("Distance: +" + INTS);

    private Part1() {
    }

    public static int getWinCountProduct(String races) {
        var lines = races.lines().iterator();

        var times = new Matcher(TIMES, lines.next()).intsGroup(1).iterator();
        var distances = new Matcher(DISTANCES, lines.next()).intsGroup(1).iterator();

        var product = 1;

        while (times.hasNext()) {
            product *= new Race(times.next(), distances.next()).getWinCount();
        }

        return product;
    }

    public static void main(String[] args) {
        AdventOfCode.printResultString(Part1::getWinCountProduct);
    }
}
