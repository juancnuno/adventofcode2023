package com.juancnuno.adventofcode2023.day10;

import java.util.Optional;

record HorizontalPipe(int rowIndex, int columnIndex) implements Pipe {

    static Optional<Pipe> valueOf(StartingPosition position, Grid grid) {
        var rowIndex = position.rowIndex();
        var columnIndex = position.columnIndex();

        if (!grid.east(rowIndex, columnIndex).map(Pipe::isConnectedToWest).orElse(false)) {
            return Optional.empty();
        }

        if (!grid.west(rowIndex, columnIndex).map(Pipe::isConnectedToEast).orElse(false)) {
            return Optional.empty();
        }

        return Optional.of(new HorizontalPipe(rowIndex, columnIndex));
    }

    @Override
    public boolean isConnectedToEast() {
        return true;
    }

    @Override
    public boolean isConnectedToWest() {
        return true;
    }

    @Override
    public Optional<Pipe> first(Grid grid) {
        return grid.east(rowIndex, columnIndex);
    }

    @Override
    public Optional<Pipe> second(Grid grid) {
        return grid.west(rowIndex, columnIndex);
    }

    @Override
    public String toString() {
        return "-";
    }
}
