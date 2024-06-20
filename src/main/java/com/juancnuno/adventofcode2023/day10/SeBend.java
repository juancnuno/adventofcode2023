package com.juancnuno.adventofcode2023.day10;

import java.util.Optional;

record SeBend(int rowIndex, int columnIndex) implements Pipe {

    static Optional<Pipe> valueOf(StartingPosition position, Grid grid) {
        var rowIndex = position.rowIndex();
        var columnIndex = position.columnIndex();

        if (!grid.south(rowIndex, columnIndex).isConnectedToNorth()) {
            return Optional.empty();
        }

        if (!grid.east(rowIndex, columnIndex).isConnectedToWest()) {
            return Optional.empty();
        }

        return Optional.of(new SeBend(rowIndex, columnIndex));
    }

    @Override
    public boolean isConnectedToSouth() {
        return true;
    }

    @Override
    public boolean isConnectedToEast() {
        return true;
    }

    @Override
    public Pipe first(Grid grid) {
        return grid.south(rowIndex, columnIndex);
    }

    @Override
    public Pipe second(Grid grid) {
        return grid.east(rowIndex, columnIndex);
    }

    @Override
    public String toString() {
        return "F";
    }
}
