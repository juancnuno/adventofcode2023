package com.juancnuno.adventofcode2023.day08;

import java.util.Iterator;

import com.juancnuno.adventofcode.AdventOfCode;

public final class Part1 {

    private Part1() {
    }

    public static int getStepCount(Iterator<String> i) {
        var instructions = i.next();
        i.next();
        var camel = new Camel(new Network(i).getMap().get("AAA"), new Instructions(instructions));

        return camel.getStepCount();
    }

    public static void main(String[] args) {
        AdventOfCode.printResultStream(stream -> getStepCount(stream.iterator()));
    }
}
