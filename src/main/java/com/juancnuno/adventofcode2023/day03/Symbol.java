package com.juancnuno.adventofcode2023.day03;

import java.util.Collection;

final class Symbol {

    private final Point location;
    private final char value;

    Symbol(Point location, char value) {
        this.location = location;
        this.value = value;
    }

    int getGearRatio(Collection<Number> partNumbers) {
        if (value != '*') {
            return 0;
        }

        var numbers = partNumbers.stream()
                .filter(this::isAdjacent)
                .toList();

        if (numbers.size() != 2) {
            return 0;
        }

        return numbers.get(0).getValue() * numbers.get(1).getValue();
    }

    private boolean isAdjacent(Number number) {
        return number.getAdjacentLocations().contains(location);
    }
}
