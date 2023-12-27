package com.juancnuno.adventofcode2023.day07;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class FullHouse extends Hand {

    private static final Object COUNTS = Set.of(2, 3);

    private FullHouse(Iterable<Card> cards) {
        super(Type.FULL_HOUSE, cards);
    }

    static Optional<Hand> newFullHouse(Map<Card, Integer> map, Iterable<Card> cards) {
        var counts = Set.copyOf(map.values());
        return counts.equals(COUNTS) ? Optional.of(new FullHouse(cards)) : Optional.empty();
    }
}
