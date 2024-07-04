package com.juancnuno.adventofcode2023.day11;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Universe(Collection<Galaxy> galaxies) {

    private Universe(Universe universe) {
        this(new HashSet<>(universe.galaxies));
    }

    public static Universe valueOf(String rows) {
        var i = rows.lines().iterator();
        var galaxies = new HashSet<Galaxy>();

        for (var rowIndex = 0; i.hasNext(); rowIndex++) {
            var row = i.next();

            for (int columnIndex = 0, columnCount = row.length(); columnIndex < columnCount; columnIndex++) {
                if (row.charAt(columnIndex) == '.') {
                    continue;
                }

                galaxies.add(new Galaxy(rowIndex, columnIndex));
            }
        }

        return new Universe(galaxies);
    }

    public Object expand() {
        return expandRows().expandColumns();
    }

    private Universe expandRows() {
        var universe = new Universe(this);

        for (int rowIndex = 0, rowCount = universe.getRowCount(); rowIndex < rowCount; rowIndex++) {
            if (!universe.isRowEmpty(rowIndex)) {
                continue;
            }

            var g = universe.filterIsRowIndexGreaterThan(rowIndex);

            universe.galaxies.removeAll(g);
            universe.galaxies.addAll(map(g, Galaxy::incrementRowIndex));

            rowIndex++;
            rowCount++;
        }

        return universe;
    }

    private boolean isRowEmpty(int rowIndex) {
        return IntStream.range(0, getColumnCount())
                .mapToObj(columnIndex -> new Galaxy(rowIndex, columnIndex))
                .noneMatch(galaxies::contains);
    }

    private Collection<Galaxy> filterIsRowIndexGreaterThan(int rowIndex) {
        return filter(galaxy -> galaxy.rowIndex() > rowIndex);
    }

    private Object expandColumns() {
        var universe = new Universe(this);

        for (int columnIndex = 0, columnCount = universe.getColumnCount(); columnIndex < columnCount; columnIndex++) {
            if (!universe.isColumnEmpty(columnIndex)) {
                continue;
            }

            var g = universe.filterIsColumnIndexGreaterThan(columnIndex);

            universe.galaxies.removeAll(g);
            universe.galaxies.addAll(map(g, Galaxy::incrementColumnIndex));

            columnIndex++;
            columnCount++;
        }

        return universe;
    }

    private boolean isColumnEmpty(int columnIndex) {
        return IntStream.range(0, getRowCount())
                .mapToObj(rowIndex -> new Galaxy(rowIndex, columnIndex))
                .noneMatch(galaxies::contains);
    }

    private Collection<Galaxy> filterIsColumnIndexGreaterThan(int columnIndex) {
        return filter(galaxy -> galaxy.columnIndex() > columnIndex);
    }

    private Collection<Galaxy> filter(Predicate<Galaxy> predicate) {
        return galaxies.stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }

    private static Collection<Galaxy> map(Collection<Galaxy> galaxies, UnaryOperator<Galaxy> operator) {
        return galaxies.stream()
                .map(operator)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        var columnCount = getColumnCount();

        return IntStream.range(0, getRowCount())
                .mapToObj(rowIndex -> toString(rowIndex, columnCount))
                .collect(Collectors.joining());
    }

    private String toString(int rowIndex, int columnCount) {
        return IntStream.range(0, columnCount)
                .mapToObj(columnIndex -> new Galaxy(rowIndex, columnIndex))
                .map(galaxy -> galaxies.contains(galaxy) ? "#" : ".")
                .collect(Collectors.joining("", "", System.lineSeparator()));
    }

    private int getRowCount() {
        return galaxies.stream()
                .mapToInt(Galaxy::rowIndex)
                .max()
                .orElseThrow() + 1;
    }

    private int getColumnCount() {
        return galaxies.stream()
                .mapToInt(Galaxy::columnIndex)
                .max()
                .orElseThrow() + 1;
    }
}
