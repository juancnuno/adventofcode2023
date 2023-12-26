package com.juancnuno.adventofcode2023.day06;

public final class Boat {

    private final int speed;

    public Boat(int speed) {
        this.speed = speed;
    }

    public boolean won(Race race) {
        var time = race.getTime() - speed;
        var distance = speed * time;

        return distance > race.getDistance();
    }
}
