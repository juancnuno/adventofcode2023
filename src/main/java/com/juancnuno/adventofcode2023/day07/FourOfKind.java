package com.juancnuno.adventofcode2023.day07;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class FourOfKind extends Hand {

    private static final Object COUNTS = Set.of(1, 4);

    private FourOfKind(Iterable<Card> cards) {
        super(Type.FOUR_OF_KIND, cards);
    }

    static Optional<Hand> newFourOfKind(Map<Card, Integer> map, Iterable<Card> cards) {
        var counts = Set.copyOf(map.values());
        return counts.equals(COUNTS) ? Optional.of(new FourOfKind(cards)) : Optional.empty();
    }
}
