package com.juancnuno.adventofcode2023.day09.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day09.History;

public final class HistoryTest {

    @Test
    public void getNext1() {
        // Arrange
        var history = new History("0 3 6 9 12 15");

        // Act
        var value = history.getNext();

        // Assert
        assertEquals(18, value);
    }

    @Test
    public void getNext2() {
        // Arrange
        var history = new History("1 3 6 10 15 21");

        // Act
        var value = history.getNext();

        // Assert
        assertEquals(28, value);
    }

    @Test
    public void getNext3() {
        // Arrange
        var history = new History("10 13 16 21 30 45");

        // Act
        var value = history.getNext();

        // Assert
        assertEquals(68, value);
    }
}
