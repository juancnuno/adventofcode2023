package com.juancnuno.adventofcode2023.day08;

final class Node {

    private final String label;
    private Node leftChild;
    private Node rightChild;

    Node(String label) {
        this.label = label;
    }

    String getLabel() {
        return label;
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
}
