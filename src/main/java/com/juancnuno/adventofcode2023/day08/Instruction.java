package com.juancnuno.adventofcode2023.day08;

public enum Instruction {
    L {
        @Override
        Node getChild(Node parent) {
            return parent.getLeftChild();
        }
    },
    R {
        @Override
        Node getChild(Node parent) {
            return parent.getRightChild();
        }
    };

    abstract Node getChild(Node parent);
}
