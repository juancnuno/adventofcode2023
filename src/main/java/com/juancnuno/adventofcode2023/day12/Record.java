package com.juancnuno.adventofcode2023.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Record(String value, Collection<Integer> sizes) {

    public static Record from(String record) {
        var valueAndSizes = record.split(" ");

        var sizes = Arrays.stream(valueAndSizes[1].split(","))
                .map(Integer::parseInt)
                .toList();

        return new Record(valueAndSizes[0], sizes);
    }

    public int getArrangementCount() {
        var i = value.indexOf('?');

        if (i == -1) {
            return getPattern().matcher(value).matches() ? 1 : 0;
        }

        var prefix = value.substring(0, i);
        var suffix = value.substring(i + 1);

        return new Record(prefix + '.' + suffix, sizes).getArrangementCount() + new Record(prefix + '#' + suffix, sizes).getArrangementCount();
    }

    private Pattern getPattern() {
        var regex = sizes.stream()
                .map("#"::repeat)
                .collect(Collectors.joining("\\.+", "\\.*", "\\.*"));

        return Pattern.compile(regex);
    }

    public Record unfold() {
        var newValue = IntStream.range(0, 5)
                .mapToObj(i -> value)
                .collect(Collectors.joining("?"));

        var newSizes = new ArrayList<Integer>(5 * sizes.size());
        IntStream.range(0, 5).forEach(i -> newSizes.addAll(sizes));

        return new Record(newValue, newSizes);
    }
}
