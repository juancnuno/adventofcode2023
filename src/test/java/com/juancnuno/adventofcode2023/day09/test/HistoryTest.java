package com.juancnuno.adventofcode2023.day09.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day09.History;

public final class HistoryTest {

    @Test
    public void getPrevious1() {
        // Arrange
        var history = new History("0 3 6 9 12 15");

        // Act
        var previous = history.getPrevious();

        // Assert
        assertEquals(-3, previous);
    }

    @Test
    public void getPrevious2() {
        // Arrange
        var history = new History("1 3 6 10 15 21");

        // Act
        var previous = history.getPrevious();

        // Assert
        assertEquals(0, previous);
    }

    @Test
    public void getPrevious3() {
        // Arrange
        var history = new History("10 13 16 21 30 45");

        // Act
        var previous = history.getPrevious();

        // Assert
        assertEquals(5, previous);
    }

    @Test
    public void getNext1() {
        // Arrange
        var history = new History("0 3 6 9 12 15");

        // Act
        var next = history.getNext();

        // Assert
        assertEquals(18, next);
    }

    @Test
    public void getNext2() {
        // Arrange
        var history = new History("1 3 6 10 15 21");

        // Act
        var next = history.getNext();

        // Assert
        assertEquals(28, next);
    }

    @Test
    public void getNext3() {
        // Arrange
        var history = new History("10 13 16 21 30 45");

        // Act
        var next = history.getNext();

        // Assert
        assertEquals(68, next);
    }
}
