package com.juancnuno.adventofcode2023.day08;

import java.util.Iterator;

final class Camel extends Stepper {

    Camel(Node currentNode, Iterator<Character> i) {
        super(currentNode, i);
    }

    @Override
    boolean isAtEnd() {
        return currentNode.getLabel().equals("ZZZ");
    }
}
