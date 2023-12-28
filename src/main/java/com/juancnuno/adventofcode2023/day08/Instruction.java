package com.juancnuno.adventofcode2023.day08;

import java.util.function.UnaryOperator;

public final class Instruction {

    public static final Instruction LEFT = new Instruction(Node::getLeftChild);
    public static final Instruction RIGHT = new Instruction(Node::getRightChild);

    private final UnaryOperator<Node> getChild;

    private Instruction(UnaryOperator<Node> getChild) {
        this.getChild = getChild;
    }

    static Instruction valueOf(char instruction) {
        return switch (instruction) {
            case 'L' ->
                LEFT;
            case 'R' ->
                RIGHT;
            default ->
                throw new IllegalArgumentException(String.valueOf(instruction));
        };
    }

    Node getChild(Node parent) {
        return getChild.apply(parent);
    }
}
