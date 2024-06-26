package com.juancnuno.adventofcode2023.day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Grid {

    private final List<List<Pipe>> rows;

    public Grid(String rows) {
        this(rows.lines().iterator());
    }

    private Grid(Iterator<String> rows) {
        this.rows = new ArrayList<>();

        for (var rowIndex = 0; rows.hasNext(); rowIndex++) {
            this.rows.add(row(rows.next(), rowIndex));
        }
    }

    private static List<Pipe> row(CharSequence row, int rowIndex) {
        return IntStream.range(0, row.length())
                .mapToObj(columnIndex -> Pipe.valueOf(row.charAt(columnIndex), rowIndex, columnIndex))
                .toList();
    }

    public int getStepCount() {
        var position = rows.stream()
                .flatMap(Collection::stream)
                .filter(StartingPosition.class::isInstance)
                .findFirst();

        var i = new PipeIterator((StartingPosition) position.orElseThrow(), this);
        var count = 1;

        for (; i.hasNext(); i.next()) {
            count++;
        }

        return count / 2;
    }

    Optional<Pipe> north(int rowIndex, int columnIndex) {
        if (rowIndex == 0) {
            return Optional.empty();
        }

        return Optional.of(rows.get(rowIndex - 1).get(columnIndex));
    }

    Optional<Pipe> south(int rowIndex, int columnIndex) {
        if (rowIndex == rows.size() - 1) {
            return Optional.empty();
        }

        return Optional.of(rows.get(rowIndex + 1).get(columnIndex));
    }

    Optional<Pipe> east(int rowIndex, int columnIndex) {
        var row = rows.get(rowIndex);

        if (columnIndex == row.size() - 1) {
            return Optional.empty();
        }

        return Optional.of(row.get(columnIndex + 1));
    }

    Optional<Pipe> west(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return Optional.empty();
        }

        return Optional.of(rows.get(rowIndex).get(columnIndex - 1));
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(Grid::toString)
                .collect(Collectors.joining());
    }

    private static CharSequence toString(Collection<Pipe> row) {
        return row.stream()
                .map(Object::toString)
                .collect(Collectors.joining("", "", System.getProperty("line.separator")));
    }
}
