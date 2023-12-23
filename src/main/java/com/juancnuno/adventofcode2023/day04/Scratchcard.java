package com.juancnuno.adventofcode2023.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Scratchcard {

    private static final String DIGITS = "\\d+";
    private static final String INTS = "((?: +" + DIGITS + ")+)";
    private static final Pattern PATTERN = Pattern.compile("Card +" + DIGITS + ':' + INTS + " \\|" + INTS);

    private final Collection<Integer> winningNumbers;
    private final Collection<Integer> numbers;

    public Scratchcard(String scratchcard) {
        var matcher = PATTERN.matcher(scratchcard);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(scratchcard);
        }

        winningNumbers = intsGroup(matcher, 1);
        numbers = intsGroup(matcher, 2);
    }

    private static Collection<Integer> intsGroup(Matcher matcher, int group) {
        return Arrays.stream(matcher.group(group).split(" +"))
                .filter(Predicate.not(CharSequence::isEmpty))
                .map(Integer::parseInt)
                .toList();
    }

    public int getWorth() {
        var n = new ArrayList<Integer>(winningNumbers);
        n.retainAll(numbers);

        var size = n.size();

        if (size == 0) {
            return 0;
        }

        var worth = 1;

        for (var i = 1; i < size; i++) {
            worth *= 2;
        }

        return worth;
    }
}
