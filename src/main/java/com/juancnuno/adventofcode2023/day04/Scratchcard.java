package com.juancnuno.adventofcode2023.day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import com.juancnuno.adventofcode.Matcher;

public record Scratchcard(Collection<Integer> winningNumbers, Collection<Integer> numbers) {

    private static final String DIGITS = "\\d+";
    private static final String INTS = "((?: *" + DIGITS + ")+)";
    private static final Pattern PATTERN = Pattern.compile("Card +" + DIGITS + ": +" + INTS + " \\| +" + INTS);

    public static Scratchcard parse(String scratchcard) {
        var matcher = new Matcher(PATTERN, scratchcard);
        return new Scratchcard(matcher.intsGroup(1), matcher.intsGroup(2));
    }

    public int getWorth() {
        var count = getWinningNumberCount();

        if (count == 0) {
            return 0;
        }

        var worth = 1;

        for (var i = 1; i < count; i++) {
            worth *= 2;
        }

        return worth;
    }

    int getWinningNumberCount() {
        var n = new ArrayList<>(winningNumbers);
        n.retainAll(numbers);

        return n.size();
    }
}
