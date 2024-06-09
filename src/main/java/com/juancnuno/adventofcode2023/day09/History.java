package com.juancnuno.adventofcode2023.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class History {

    private final int[] values;

    public History(String history) {
        values = Arrays.stream(history.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private History(History history) {
        this.values = IntStream.range(1, history.values.length)
                .map(history::getMinusPrevious)
                .toArray();
    }

    private int getMinusPrevious(int i) {
        return values[i] - values[i - 1];
    }

    public int getNext() {
        var histories = new ArrayList<>(List.of(this));

        for (var history = histories.getLast(); !history.areAllEqualToZero();
                history = histories.getLast()) {
            histories.add(new History(history));
        }

        var nextValue = 0;

        for (var i = histories.size() - 2; i >= 0; i--) {
            nextValue += histories.get(i).getLast();
        }

        return nextValue;
    }

    private boolean areAllEqualToZero() {
        return Arrays.stream(values).allMatch(value -> value == 0);
    }

    private int getLast() {
        return values[values.length - 1];
    }

    @Override
    public String toString() {
        return Arrays.stream(values)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
    }
}
