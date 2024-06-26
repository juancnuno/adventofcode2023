package com.juancnuno.adventofcode2023.day10;

import java.util.Optional;

record SwBend(int rowIndex, int columnIndex) implements Pipe {

    static Optional<Pipe> valueOf(StartingPosition position, Grid grid) {
        var rowIndex = position.rowIndex();
        var columnIndex = position.columnIndex();

        if (!grid.south(rowIndex, columnIndex).map(Pipe::isConnectedToNorth).orElse(false)) {
            return Optional.empty();
        }

        if (!grid.west(rowIndex, columnIndex).map(Pipe::isConnectedToEast).orElse(false)) {
            return Optional.empty();
        }

        return Optional.of(new SwBend(rowIndex, columnIndex));
    }

    @Override
    public boolean isConnectedToSouth() {
        return true;
    }

    @Override
    public boolean isConnectedToWest() {
        return true;
    }

    @Override
    public Pipe first(Grid grid) {
        return grid.south(rowIndex, columnIndex).orElseThrow();
    }

    @Override
    public Pipe second(Grid grid) {
        return grid.west(rowIndex, columnIndex).orElseThrow();
    }

    @Override
    public String toString() {
        return "7";
    }
}
