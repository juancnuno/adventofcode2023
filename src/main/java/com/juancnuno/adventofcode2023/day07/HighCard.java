package com.juancnuno.adventofcode2023.day07;

import java.util.Map;
import java.util.Optional;

public final class HighCard extends Hand {

    private HighCard(Iterable<Card> cards) {
        super(Type.HIGH_CARD, cards);
    }

    static Optional<Hand> newHighCard(Map<Card, Integer> map, Iterable<Card> cards) {
        return map.size() == 5 ? Optional.of(new HighCard(cards)) : Optional.empty();
    }
}
