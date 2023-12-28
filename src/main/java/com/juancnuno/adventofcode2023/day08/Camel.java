package com.juancnuno.adventofcode2023.day08;

import java.util.Iterator;

public final class Camel {

    private final Network network;
    private final Iterator<Instruction> i;

    public Camel(Iterator<String> i) {
        var instructions = i.next();
        i.next();

        network = new Network(i);
        this.i = new Instructions(instructions);
    }

    public int getStepCount() {
        var count = 0;

        for (var node = network.getStart(); !node.isEnd(); node = i.next().getChild(node)) {
            count++;
        }

        return count;
    }
}
