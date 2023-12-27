package com.juancnuno.adventofcode2023.day07;

import java.util.Map;
import java.util.Optional;

public final class FiveOfKind extends Hand {

    private FiveOfKind(Iterable<Card> cards) {
        super(Type.FIVE_OF_KIND, cards);
    }

    static Optional<Hand> newFiveOfKind(Map<Card, Integer> map, Iterable<Card> cards) {
        return map.size() == 1 ? Optional.of(new FiveOfKind(cards)) : Optional.empty();
    }
}
