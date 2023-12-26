package com.juancnuno.adventofcode2023.day06;

public final class Race {

    private final int time;
    private final int distance;

    public Race(int time, int distance) {
        this.time = time;
        this.distance = distance;
    }

    int getTime() {
        return time;
    }

    int getDistance() {
        return distance;
    }
}
