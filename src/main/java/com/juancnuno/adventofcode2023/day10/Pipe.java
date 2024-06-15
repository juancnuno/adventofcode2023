package com.juancnuno.adventofcode2023.day10;

class Pipe {

    static Object valueOf(char pipe) {
        return switch (pipe) {
            case '|' ->
                new VerticalPipe();
            case '-' ->
                new HorizontalPipe();
            case 'L' ->
                new NeBend();
            case 'J' ->
                new NwBend();
            case '7' ->
                new SwBend();
            case 'F' ->
                new SeBend();
            case '.' ->
                new Ground();
            default ->
                throw new IllegalArgumentException(String.valueOf(pipe));
        };
    }
}
