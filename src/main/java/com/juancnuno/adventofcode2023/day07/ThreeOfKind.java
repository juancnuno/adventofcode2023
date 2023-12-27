package com.juancnuno.adventofcode2023.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class ThreeOfKind extends Hand {

    private static final Object COUNTS = List.of(1, 1, 3);

    private ThreeOfKind(Iterable<Card> cards) {
        super(Type.THREE_OF_KIND, cards);
    }

    static Optional<Hand> newThreeOfKind(Map<Card, Integer> map, Iterable<Card> cards) {
        var counts = new ArrayList<>(map.values());
        counts.sort(null);

        return counts.equals(COUNTS) ? Optional.of(new ThreeOfKind(cards)) : Optional.empty();
    }
}
