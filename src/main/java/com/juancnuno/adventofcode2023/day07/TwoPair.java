package com.juancnuno.adventofcode2023.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class TwoPair extends Hand {

    private static final Object COUNTS = List.of(1, 2, 2);

    private TwoPair(Iterable<Card> cards) {
        super(Type.TWO_PAIR, cards);
    }

    static Optional<Hand> newTwoPair(Map<Card, Integer> map, Iterable<Card> cards) {
        var counts = new ArrayList<>(map.values());
        counts.sort(null);

        return counts.equals(COUNTS) ? Optional.of(new TwoPair(cards)) : Optional.empty();
    }
}
