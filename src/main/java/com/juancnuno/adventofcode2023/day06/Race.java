package com.juancnuno.adventofcode2023.day06;

import java.util.stream.IntStream;

final class Race {

    private final int time;
    private final long distance;

    Race(int time, long distance) {
        this.time = time;
        this.distance = distance;
    }

    int getWinCount() {
        return (int) IntStream.rangeClosed(0, time)
                .mapToObj(Boat::new)
                .filter(boat -> boat.won(this))
                .count();
    }

    int getTime() {
        return time;
    }

    long getDistance() {
        return distance;
    }
}
