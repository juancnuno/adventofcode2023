package com.juancnuno.adventofcode2023.day09.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day09.History;

public final class HistoryTest {

    @Test
    public void getNext() {
        // Arrange
        var history = new History("0 3 6 9 12 15");

        // Act
        var value = history.getNext();

        // Assert
        assertEquals(18, value);
    }
}
