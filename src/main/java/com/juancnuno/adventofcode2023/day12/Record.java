package com.juancnuno.adventofcode2023.day12;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Record {

    private final CharSequence value;
    private final Collection<Integer> sizes;

    public Record(String record) {
        var valueAndSizes = record.split(" ");
        value = valueAndSizes[0];

        sizes = Arrays.stream(valueAndSizes[1].split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public int getArrangementCount() {
        var pattern = getPattern();

        return (int) getArrangements(value).stream()
                .map(pattern::matcher)
                .filter(Matcher::matches)
                .count();
    }

    private Pattern getPattern() {
        var regex = sizes.stream()
                .map("#"::repeat)
                .collect(Collectors.joining("\\.+", "\\.*", "\\.*"));

        return Pattern.compile(regex);
    }

    public static Collection<String> getArrangements(CharSequence value) {
        if (value.equals("")) {
            return List.of("");
        }

        var prefix = value.charAt(0);
        var prefixes = prefix == '?' ? Stream.of('.', '#') : Stream.of(prefix);
        var arrangements = getArrangements(value.subSequence(1, value.length()));

        return prefixes
                .flatMap(p -> prepend(arrangements, p))
                .toList();
    }

    private static Stream<String> prepend(Collection<String> arrangements, char prefix) {
        return arrangements.stream().map(arrangement -> prefix + arrangement);
    }
}
