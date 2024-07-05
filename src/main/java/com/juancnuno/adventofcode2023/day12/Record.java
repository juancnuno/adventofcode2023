package com.juancnuno.adventofcode2023.day12;

import java.util.Collection;
import java.util.List;

public final class Record {

    private final Object value;

    public Record(String record) {
        value = record.split(" ")[0];
    }

    public int getArrangementCount() {
        return 0;
    }

    public static Collection<String> getArrangements(String value) {
        if (value.equals("")) {
            return List.of("");
        }

        var c = value.charAt(0);

        if (c == '?') {
            return List.of();
        }

        return getArrangements(value.substring(1, value.length())).stream()
                .map(arrangement -> c + arrangement)
                .toList();
    }
}
