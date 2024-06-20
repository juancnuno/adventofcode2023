package com.juancnuno.adventofcode2023.day10;

final class Ground implements Pipe {

    static final Pipe INSTANCE = new Ground();

    private Ground() {
    }

    @Override
    public int rowIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int columnIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pipe first(Grid grid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pipe second(Grid grid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return ".";
    }
}
