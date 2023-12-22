package com.juancnuno.adventofcode2023.day03;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

import com.juancnuno.adventofcode.AdventOfCode;
import com.juancnuno.adventofcode.CharSequences;

public final class Part1 {

    private final Stream<String> lines;
    private final Collection<Number> numbers;
    private final Collection<Point> symbolLocations;
    private final StringBuilder builder;

    private int x;
    private int y;
    private Point location;

    public Part1(Stream<String> lines) {
        this.lines = lines;

        numbers = new HashSet<>();
        symbolLocations = new HashSet<>();
        builder = new StringBuilder();
    }

    public int getPartNumberSum() {
        lines.forEach(this::parse);

        return numbers.stream()
                .filter(number -> number.isPartNumber(symbolLocations))
                .mapToInt(Number::value)
                .sum();
    }

    private void parse(CharSequence line) {
        CharSequences.chars(line).forEach(c -> {
            switch (c) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                    handleDigit(c);
                }
                case '.' -> {
                    addNumber();
                }
                default -> {
                    handleSymbol();
                }
            }

            y++;
        });

        x++;
        y = 0;
    }

    private void handleDigit(char digit) {
        if (builder.isEmpty()) {
            location = new Point(x, y);
        }

        builder.append(digit);
    }

    private void handleSymbol() {
        addNumber();
        symbolLocations.add(new Point(x, y));
    }

    private void addNumber() {
        if (builder.isEmpty()) {
            return;
        }

        numbers.add(new Number(location, Integer.parseInt(builder, 0, builder.length(), 10)));

        builder.setLength(0);
        location = null;
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(lines -> new Part1(lines).getPartNumberSum());
    }
}
