package com.juancnuno.adventofcode2023.day12;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public final class Record {

    private final Object value;

    public Record(String record) {
        value = record.split(" ")[0];
    }

    public int getArrangementCount() {
        return 0;
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
