package com.juancnuno.adventofcode2023.day08;

import java.util.Iterator;

public final class Instructions implements Iterator<Instruction> {

    private final CharSequence instructions;
    private int index;

    public Instructions(CharSequence instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Instruction next() {
        if (index == instructions.length()) {
            index = 0;
        }

        return Instruction.valueOf(instructions.charAt(index++));
    }
}
