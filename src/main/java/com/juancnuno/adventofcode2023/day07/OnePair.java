package com.juancnuno.adventofcode2023.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class OnePair extends Hand {

    private static final Object COUNTS = List.of(1, 1, 1, 2);

    private OnePair(Iterable<Card> cards) {
        super(Type.ONE_PAIR, cards);
    }

    static Optional<Hand> newOnePair(Map<Card, Integer> map, Iterable<Card> cards) {
        var counts = new ArrayList<>(map.values());
        counts.sort(null);

        return counts.equals(COUNTS) ? Optional.of(new OnePair(cards)) : Optional.empty();
    }
}
