package com.juancnuno.adventofcode2023.day11;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Universe {

    private final Collection<Galaxy> galaxies;

    public Universe(String rows) {
        var i = rows.lines().iterator();
        galaxies = new HashSet<>();

        for (var rowIndex = 0; i.hasNext(); rowIndex++) {
            var row = i.next();

            for (int columnIndex = 0, columnCount = row.length(); columnIndex < columnCount; columnIndex++) {
                if (row.charAt(columnIndex) == '.') {
                    continue;
                }

                galaxies.add(new Galaxy(rowIndex, columnIndex));
            }
        }
    }

    @Override
    public String toString() {
        var rowCount = galaxies.stream()
                .mapToInt(Galaxy::rowIndex)
                .max()
                .orElseThrow() + 1;

        var columnCount = galaxies.stream()
                .mapToInt(Galaxy::columnIndex)
                .max()
                .orElseThrow() + 1;

        return IntStream.range(0, rowCount)
                .mapToObj(rowIndex -> toString(rowIndex, columnCount))
                .collect(Collectors.joining());
    }

    private String toString(int rowIndex, int columnCount) {
        return IntStream.range(0, columnCount)
                .mapToObj(columnIndex -> new Galaxy(rowIndex, columnIndex))
                .map(galaxy -> galaxies.contains(galaxy) ? "#" : ".")
                .collect(Collectors.joining("", "", System.lineSeparator()));
    }
}
