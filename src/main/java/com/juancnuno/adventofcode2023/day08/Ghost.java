package com.juancnuno.adventofcode2023.day08;

import java.util.Iterator;

final class Ghost extends Stepper {

    Ghost(Node currentNode, Iterator<Instruction> i) {
        super(currentNode, i);
    }

    @Override
    boolean isAtEnd() {
        return currentNode.getLabel().endsWith("Z");
    }
}
