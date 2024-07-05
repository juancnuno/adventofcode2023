package com.juancnuno.adventofcode2023.day12;

import java.util.List;

public final class Record {

    private final Object value;

    public Record(String record) {
        value = record.split(" ")[0];
    }

    public int getArrangementCount() {
        return 0;
    }

    public static Object getArrangements(Object value) {
        if (value.equals("")) {
            return List.of("");
        }

        return List.of();
    }
}
