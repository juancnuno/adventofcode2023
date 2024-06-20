package com.juancnuno.adventofcode2023.day10;

import java.util.Optional;

record VerticalPipe(int rowIndex, int columnIndex) implements Pipe {

    static Optional<Pipe> valueOf(StartingPosition position, Grid grid) {
        var rowIndex = position.rowIndex();
        var columnIndex = position.columnIndex();

        if (!grid.north(rowIndex, columnIndex).map(Pipe::isConnectedToSouth).orElse(false)) {
            return Optional.empty();
        }

        if (!grid.south(rowIndex, columnIndex).map(Pipe::isConnectedToNorth).orElse(false)) {
            return Optional.empty();
        }

        return Optional.of(new VerticalPipe(rowIndex, columnIndex));
    }

    @Override
    public boolean isConnectedToNorth() {
        return true;
    }

    @Override
    public boolean isConnectedToSouth() {
        return true;
    }

    @Override
    public Optional<Pipe> first(Grid grid) {
        return grid.north(rowIndex, columnIndex);
    }

    @Override
    public Optional<Pipe> second(Grid grid) {
        return grid.south(rowIndex, columnIndex);
    }

    @Override
    public String toString() {
        return "|";
    }
}
