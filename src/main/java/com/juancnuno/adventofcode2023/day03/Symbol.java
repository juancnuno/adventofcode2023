package com.juancnuno.adventofcode2023.day03;

import java.util.Collection;

record Symbol(Point location, char value) {

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

        return numbers.get(0).value() * numbers.get(1).value();
    }

    private boolean isAdjacent(Number number) {
        return number.getAdjacentLocations().contains(location);
    }
}
