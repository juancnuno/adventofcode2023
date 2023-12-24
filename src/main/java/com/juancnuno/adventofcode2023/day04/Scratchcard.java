package com.juancnuno.adventofcode2023.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import com.juancnuno.adventofcode.Matcher;

public record Scratchcard(Collection<Integer> winningNumbers, Collection<Integer> numbers) {

    private static final String DIGITS = "\\d+";
    private static final String INTS = "((?: +" + DIGITS + ")+)";
    private static final Pattern PATTERN = Pattern.compile("Card +" + DIGITS + ':' + INTS + " \\|" + INTS);

    public static Scratchcard parse(String scratchcard) {
        var matcher = new Matcher(PATTERN, scratchcard);
        return new Scratchcard(ints(matcher.group(1)), ints(matcher.group(2)));
    }

    private static Collection<Integer> ints(String string) {
        return Arrays.stream(string.split(" +"))
                .filter(Predicate.not(CharSequence::isEmpty))
                .map(Integer::parseInt)
                .toList();
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
