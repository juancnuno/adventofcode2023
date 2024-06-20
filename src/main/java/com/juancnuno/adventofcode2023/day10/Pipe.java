package com.juancnuno.adventofcode2023.day10;

interface Pipe {

    static Pipe valueOf(char pipe, int rowIndex, int columnIndex) {
        return switch (pipe) {
            case '|' ->
                new VerticalPipe(rowIndex, columnIndex);
            case '-' ->
                new HorizontalPipe(rowIndex, columnIndex);
            case 'L' ->
                new NeBend(rowIndex, columnIndex);
            case 'J' ->
                new NwBend(rowIndex, columnIndex);
            case '7' ->
                new SwBend(rowIndex, columnIndex);
            case 'F' ->
                new SeBend(rowIndex, columnIndex);
            case '.' ->
                Ground.INSTANCE;
            case 'S' ->
                new StartingPosition(rowIndex, columnIndex);
            default ->
                throw new IllegalArgumentException(String.valueOf(pipe));
        };
    }

    static Pipe valueOf(StartingPosition position, Grid grid) {
        return VerticalPipe.valueOf(position, grid)
                .or(() -> HorizontalPipe.valueOf(position, grid))
                .or(() -> NeBend.valueOf(position, grid))
                .or(() -> NwBend.valueOf(position, grid))
                .or(() -> SwBend.valueOf(position, grid))
                .or(() -> SeBend.valueOf(position, grid))
                .orElseThrow();
    }

    int rowIndex();

    int columnIndex();

    default boolean isConnectedToNorth() {
        return false;
    }

    default boolean isConnectedToSouth() {
        return false;
    }

    default boolean isConnectedToEast() {
        return false;
    }

    default boolean isConnectedToWest() {
        return false;
    }

    default Pipe next(Object previous, Grid grid) {
        var first = first(grid);
        return previous.equals(first) ? second(grid) : first;
    }

    Pipe first(Grid grid);

    Pipe second(Grid grid);
}
