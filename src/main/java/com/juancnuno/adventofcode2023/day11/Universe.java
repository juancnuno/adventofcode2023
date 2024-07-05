package com.juancnuno.adventofcode2023.day11;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Sets;

public record Universe(Set<Galaxy> galaxies) {

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

    public Universe expand() {
        return expand(2);
    }

    public Universe expand(int amount) {
        amount--;
        return expandRows(amount).expandColumns(amount);
    }

    private Universe expandRows(int amount) {
        var universe = new Universe(this);

        for (int rowIndex = 0, rowCount = universe.getRowCount(); rowIndex < rowCount; rowIndex++) {
            if (!universe.isRowEmpty(rowIndex)) {
                continue;
            }

            var g = universe.filterIsRowIndexGreaterThan(rowIndex);

            universe.galaxies.removeAll(g);
            universe.galaxies.addAll(map(g, galaxy -> galaxy.incrementRowIndex(amount)));

            rowIndex += amount;
            rowCount += amount;
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

    private Universe expandColumns(int amount) {
        var universe = new Universe(this);

        for (int columnIndex = 0, columnCount = universe.getColumnCount(); columnIndex < columnCount; columnIndex++) {
            if (!universe.isColumnEmpty(columnIndex)) {
                continue;
            }

            var g = universe.filterIsColumnIndexGreaterThan(columnIndex);

            universe.galaxies.removeAll(g);
            universe.galaxies.addAll(map(g, galaxy -> galaxy.incrementColumnIndex(amount)));

            columnIndex += amount;
            columnCount += amount;
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

    public int getDistanceSum() {
        return getDistanceSum(2);
    }

    public int getDistanceSum(int amount) {
        return Sets.combinations(expand(amount).galaxies, 2).stream()
                .mapToInt(Universe::distance)
                .sum();
    }

    private static int distance(Iterable<Galaxy> pair) {
        var i = pair.iterator();
        return i.next().distance(i.next());
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
