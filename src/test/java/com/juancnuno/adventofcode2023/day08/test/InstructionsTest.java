package com.juancnuno.adventofcode2023.day08.test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day08.Instruction;
import com.juancnuno.adventofcode2023.day08.Instructions;

public final class InstructionsTest {

    @Test
    public void next() {
        // Arrange
        var i = new Instructions("RL");

        // Act
        var instructions = List.of(i.next(), i.next(), i.next());

        // Assert
        assertEquals(List.of(Instruction.R, Instruction.L, Instruction.R), instructions);
    }
}
