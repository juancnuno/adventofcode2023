package com.juancnuno.adventofcode2023.day07;

import java.util.Comparator;

import com.juancnuno.adventofcode.CharSequences;

public class Hand implements Comparable<Hand> {

    private static final Comparator<Hand> comparator = Comparator.<Hand, Type>comparing(hand -> hand.type)
            .thenComparing((Hand hand1, Hand hand2) -> {
                var i = hand1.cards.iterator();
                var j = hand2.cards.iterator();

                var card1 = i.next();
                var card2 = j.next();

                while (card1.equals(card2) && i.hasNext()) {
                    card1 = i.next();
                    card2 = j.next();
                }

                return card1.compareTo(card2);
            });

    private final Type type;
    private final Iterable<Card> cards;

    Hand(Type type, Iterable<Card> cards) {
        this.type = type;
        this.cards = cards;
    }

    public static Hand parse(String hand, Rule rule) {
        var cards = CharSequences.chars(hand)
                .map(card -> Card.valueOf(card, rule))
                .toList();

        var map = rule.count(cards);

        return FiveOfKind.newFiveOfKind(map, cards)
                .or(() -> FourOfKind.newFourOfKind(map, cards))
                .or(() -> FullHouse.newFullHouse(map, cards))
                .or(() -> ThreeOfKind.newThreeOfKind(map, cards))
                .or(() -> TwoPair.newTwoPair(map, cards))
                .or(() -> OnePair.newOnePair(map, cards))
                .or(() -> HighCard.newHighCard(map, cards))
                .orElseThrow(() -> new IllegalArgumentException(hand));
    }

    @Override
    public final int compareTo(Hand hand) {
        return comparator.compare(this, hand);
    }
}
