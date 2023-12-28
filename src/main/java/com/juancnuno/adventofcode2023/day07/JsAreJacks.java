package com.juancnuno.adventofcode2023.day07;

import java.util.Collection;
import java.util.Map;

import com.juancnuno.adventofcode.Multisets;

public final class JsAreJacks extends Rule {

    public static final Rule INSTANCE = new JsAreJacks();

    private JsAreJacks() {
        super(Card.JACK);
    }

    @Override
    Map<Card, Integer> count(Collection<Card> cards) {
        return cards.stream().collect(Multisets.toEnumMultiset(Card.class));
    }
}
