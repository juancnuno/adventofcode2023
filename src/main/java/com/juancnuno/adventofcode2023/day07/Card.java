package com.juancnuno.adventofcode2023.day07;

enum Card {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    static Card valueOf(char card) {
        return switch (card) {
            case '2' ->
                TWO;
            case '3' ->
                THREE;
            case '4' ->
                FOUR;
            case '5' ->
                FIVE;
            case '6' ->
                SIX;
            case '7' ->
                SEVEN;
            case '8' ->
                EIGHT;
            case '9' ->
                NINE;
            case 'T' ->
                TEN;
            case 'J' ->
                JACK;
            case 'Q' ->
                QUEEN;
            case 'K' ->
                KING;
            case 'A' ->
                ACE;
            default ->
                throw new IllegalArgumentException(String.valueOf(card));
        };
    }
}
