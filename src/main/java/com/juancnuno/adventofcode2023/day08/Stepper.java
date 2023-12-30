package com.juancnuno.adventofcode2023.day08;

import java.util.Iterator;

abstract class Stepper {

    Node currentNode;
    private final Iterator<Character> i;

    Stepper(Node currentNode, Iterator<Character> i) {
        this.currentNode = currentNode;
        this.i = i;
    }

    final int getStepCount() {
        var count = 0;

        for (; !isAtEnd(); currentNode = nextNode()) {
            count++;
        }

        return count;
    }

    abstract boolean isAtEnd();

    private Node nextNode() {
        var instruction = i.next();

        return switch (instruction) {
            case 'L' ->
                currentNode.getLeftChild();
            case 'R' ->
                currentNode.getRightChild();
            default ->
                throw new AssertionError(instruction);
        };
    }
}
