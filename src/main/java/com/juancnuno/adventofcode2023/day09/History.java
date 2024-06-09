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
        values = IntStream.range(1, history.values.length)
                .map(history::getMinusPrevious)
                .toArray();
    }

    private int getMinusPrevious(int i) {
        return values[i] - values[i - 1];
    }

    public int getPrevious() {
        var histories = getHistories();
        var previous = 0;

        for (var i = histories.size() - 2; i >= 0; i--) {
            previous = histories.get(i).getFirst() - previous;
        }

        return previous;
    }

    private int getFirst() {
        return values[0];
    }

    public int getNext() {
        var histories = getHistories();
        var next = 0;

        for (var i = histories.size() - 2; i >= 0; i--) {
            next += histories.get(i).getLast();
        }

        return next;
    }

    private int getLast() {
        return values[values.length - 1];
    }

    private List<History> getHistories() {
        var histories = new ArrayList<>(List.of(this));

        for (var history = histories.getLast(); !history.areAllEqualToZero();
                history = histories.getLast()) {
            histories.add(new History(history));
        }

        return histories;
    }

    private boolean areAllEqualToZero() {
        return Arrays.stream(values).allMatch(value -> value == 0);
    }

    @Override
    public String toString() {
        return Arrays.stream(values)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
    }
}
