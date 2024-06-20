package com.juancnuno.adventofcode2023.day10;

import java.util.Optional;

final class StartingPosition implements Pipe {

    private final int rowIndex;
    private final int columnIndex;

    StartingPosition(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    @Override
    public int rowIndex() {
        return rowIndex;
    }

    @Override
    public int columnIndex() {
        return columnIndex;
    }

    @Override
    public Optional<Pipe> first(Grid grid) {
        return Pipe.valueOf(this, grid).first(grid);
    }

    @Override
    public Optional<Pipe> second(Grid grid) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "S";
    }
}
