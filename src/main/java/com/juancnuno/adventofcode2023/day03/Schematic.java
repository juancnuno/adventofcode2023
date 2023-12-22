package com.juancnuno.adventofcode2023.day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.juancnuno.adventofcode.CharSequences;

public final class Schematic {

    private final Stream<String> lines;
    private final Collection<Number> numbers;
    private final Map<Point, Symbol> locationToSymbolMap;
    private final StringBuilder builder;

    private int x;
    private int y;
    private Point location;

    public Schematic(Stream<String> lines) {
        this.lines = lines;

        numbers = new ArrayList<>();
        locationToSymbolMap = new HashMap<>();
        builder = new StringBuilder();
    }

    public int getPartNumberSum() {
        lines.forEach(this::parse);

        return partNumbers()
                .mapToInt(Number::getValue)
                .sum();
    }

    public int getGearRatioSum() {
        lines.forEach(this::parse);
        var partNumbers = partNumbers().toList();

        return locationToSymbolMap.values().stream()
                .mapToInt(symbol -> symbol.getGearRatio(partNumbers))
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
                    handleSymbol(c);
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

    private void handleSymbol(char symbol) {
        addNumber();

        var l = new Point(x, y);
        locationToSymbolMap.put(l, new Symbol(l, symbol));
    }

    private void addNumber() {
        if (builder.isEmpty()) {
            return;
        }

        numbers.add(new Number(location, Integer.parseInt(builder, 0, builder.length(), 10)));

        builder.setLength(0);
        location = null;
    }

    private Stream<Number> partNumbers() {
        var locations = locationToSymbolMap.keySet();
        return numbers.stream().filter(number -> number.isPartNumber(locations));
    }
}
