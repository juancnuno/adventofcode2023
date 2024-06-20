package com.juancnuno.adventofcode2023.day10;

import java.util.Iterator;

final class PipeIterator implements Iterator<Object> {

    private final Object startingPosition;
    private final Grid grid;

    private Object previous;
    private Pipe next;

    PipeIterator(StartingPosition startingPosition, Grid grid) {
        this.startingPosition = startingPosition;
        this.grid = grid;

        previous = startingPosition;
        next = startingPosition.first(grid).orElseThrow();
    }

    @Override
    public boolean hasNext() {
        return !next.equals(startingPosition);
    }

    @Override
    public Object next() {
        var oldNext = next;

        next = next.next(previous, grid);
        previous = oldNext;

        return oldNext;
    }
}
