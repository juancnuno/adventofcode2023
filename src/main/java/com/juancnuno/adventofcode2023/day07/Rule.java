package com.juancnuno.adventofcode2023.day07;

import java.util.Collection;
import java.util.Map;

public abstract class Rule {

    private final Card card;

    Rule(Card card) {
        this.card = card;
    }

    final Card getCard() {
        return card;
    }

    abstract Map<Card, Integer> count(Collection<Card> cards);
}
