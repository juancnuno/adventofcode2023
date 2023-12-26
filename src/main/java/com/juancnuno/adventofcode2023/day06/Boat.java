package com.juancnuno.adventofcode2023.day06;

final class Boat {

    private final int speed;

    Boat(int speed) {
        this.speed = speed;
    }

    boolean won(Race race) {
        var time = race.getTime() - speed;
        var distance = (long) speed * time;

        return distance > race.getDistance();
    }
}
