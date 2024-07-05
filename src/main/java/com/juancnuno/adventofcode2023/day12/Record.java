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

        return switch (value.charAt(0)) {
            case '.' ->
                getArrangements(value.substring(1, value.length())).stream().map(arrangement -> '.' + arrangement).toList();
            case '#' ->
                List.of();
            case '?' ->
                List.of();
            default ->
                throw new IllegalArgumentException(value);
        };
    }
}
