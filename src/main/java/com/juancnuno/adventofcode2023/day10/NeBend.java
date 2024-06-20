package com.juancnuno.adventofcode2023.day10;

import java.util.Optional;

record NeBend(int rowIndex, int columnIndex) implements Pipe {

    static Optional<Pipe> valueOf(StartingPosition position, Grid grid) {
        var rowIndex = position.rowIndex();
        var columnIndex = position.columnIndex();

        if (!grid.north(rowIndex, columnIndex).isConnectedToSouth()) {
            return Optional.empty();
        }

        if (!grid.east(rowIndex, columnIndex).isConnectedToWest()) {
            return Optional.empty();
        }

        return Optional.of(new NeBend(rowIndex, columnIndex));
    }

    @Override
    public boolean isConnectedToNorth() {
        return true;
    }

    @Override
    public boolean isConnectedToEast() {
        return true;
    }

    @Override
    public Pipe first(Grid grid) {
        return grid.north(rowIndex, columnIndex);
    }

    @Override
    public Pipe second(Grid grid) {
        return grid.east(rowIndex, columnIndex);
    }

    @Override
    public String toString() {
        return "L";
    }
}
