package com.juancnuno.adventofcode2023.day08;

final class Node {

    private final Object label;
    private Node leftChild;
    private Node rightChild;

    Node(String label) {
        this.label = label;
    }

    Node getLeftChild() {
        return leftChild;
    }

    void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    Node getRightChild() {
        return rightChild;
    }

    void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    boolean isEnd() {
        return label.equals("ZZZ");
    }
}
