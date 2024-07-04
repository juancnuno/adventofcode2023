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
        var i = new PipeIterator(getStartingPosition(), this);
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

    public int getEnclosedTileCount() {
        // Pick's theorem
        return getArea() - getStepCount() + 1;
    }

    private int getArea() {
        var position = getStartingPosition();
        var i = new PipeIterator(position, this);

        var pipes = new ArrayList<Pipe>();
        pipes.add(position);

        while (i.hasNext()) {
            pipes.add(i.next());
        }

        // Shoelace formula
        var area = 0;

        for (int j = 1, size = pipes.size(); j < size; j++) {
            area += determinant(pipes.get(j - 1), pipes.get(j));
        }

        area += determinant(pipes.getLast(), pipes.getFirst());
        return area / 2;
    }

    private static int determinant(Pipe pipe1, Pipe pipe2) {
        return pipe1.rowIndex() * pipe2.columnIndex() - pipe2.rowIndex() * pipe1.columnIndex();
    }

    private StartingPosition getStartingPosition() {
        return (StartingPosition) rows.stream()
                .flatMap(Collection::stream)
                .filter(StartingPosition.class::isInstance)
                .findFirst()
                .orElseThrow();
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
