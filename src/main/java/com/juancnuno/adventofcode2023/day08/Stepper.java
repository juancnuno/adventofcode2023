package com.juancnuno.adventofcode2023.day08;

import java.util.Iterator;

abstract class Stepper {

    Node currentNode;
    private final Iterator<Instruction> i;

    Stepper(Node currentNode, Iterator<Instruction> i) {
        this.currentNode = currentNode;
        this.i = i;
    }

    final int getStepCount() {
        var count = 0;

        for (; !isAtEnd(); currentNode = i.next().getChild(currentNode)) {
            count++;
        }

        return count;
    }

    abstract boolean isAtEnd();
}
