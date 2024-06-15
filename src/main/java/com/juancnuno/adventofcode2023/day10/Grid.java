package com.juancnuno.adventofcode2023.day10;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.juancnuno.adventofcode.CharSequences;

public final class Grid {

    private final Collection<Collection<Object>> rows;

    public Grid(String rows) {
        this(rows.lines());
    }

    private Grid(Stream<String> rows) {
        this.rows = rows
                .map(Grid::row)
                .toList();
    }

    private static Collection<Object> row(CharSequence row) {
        return CharSequences.chars(row)
                .map(Pipe::valueOf)
                .toList();
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(Grid::toString)
                .collect(Collectors.joining());
    }

    private static CharSequence toString(Collection<Object> row) {
        return row.stream()
                .map(Object::toString)
                .collect(Collectors.joining("", "", System.getProperty("line.separator")));
    }
}
