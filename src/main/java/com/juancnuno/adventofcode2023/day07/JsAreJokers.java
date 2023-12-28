package com.juancnuno.adventofcode2023.day07;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import com.juancnuno.adventofcode.Multisets;

public final class JsAreJokers extends Rule {

    public static final Rule INSTANCE = new JsAreJokers();

    private JsAreJokers() {
        super(Card.JOKER);
    }

    @Override
    Map<Card, Integer> count(Collection<Card> cards) {
        return switch (Collections.frequency(cards, Card.JOKER)) {
            case 0, 5 ->
                JsAreJacks.INSTANCE.count(cards);
            case 1, 2, 3, 4 ->
                countContainsJokers(cards);
            default ->
                throw new IllegalArgumentException(cards.toString());
        };
    }

    private static Map<Card, Integer> countContainsJokers(Collection<Card> cards) {
        var map = JsAreJacks.INSTANCE.count(cards);
        var count = map.remove(Card.JOKER);

        var entry = map.entrySet().stream()
                .max(Comparator.comparing(Entry::getValue))
                .orElseThrow();

        Multisets.put(map, entry.getKey(), count);
        return map;
    }
}
