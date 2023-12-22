package com.juancnuno.adventofcode2023.day03;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.IntStream;

public record Number(Point location, int value) {

    public boolean isPartNumber(Collection<Point> symbolLocations) {
        return !Collections.disjoint(symbolLocations, getAdjacentLocations());
    }

    public Collection<Point> getAdjacentLocations() {
        var locationX = location.x();
        var locationY = location.y();

        var locations = new HashSet<Point>();

        IntStream.range(locationY - 1, locationY + getValueLength() + 1).forEach(y -> {
            locations.add(new Point(locationX - 1, y));
            locations.add(new Point(locationX + 1, y));
        });

        locations.add(new Point(locationX, locationY - 1));
        locations.add(new Point(locationX, locationY + getValueLength()));

        return locations;
    }

    public int getValueLength() {
        var length = 0;

        for (var v = value; v != 0; v /= 10) {
            length++;
        }

        return length;
    }
}
