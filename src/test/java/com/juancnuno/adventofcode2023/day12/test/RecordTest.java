package com.juancnuno.adventofcode2023.day12.test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day12.Record;

public final class RecordTest {

    @Disabled
    @Test
    public void getArrangementCount() {
        // Arrange
        var record = new Record("???.### 1,1,3");

        // Act
        var count = record.getArrangementCount();

        // Assert
        assertEquals(1, count);
    }

    @Test
    public void getArrangements1() {
        // Act
        var arrangements = Record.getArrangements("");

        // Assert
        assertEquals(List.of(""), arrangements);
    }

    @Test
    public void getArrangements2() {
        // Act
        var arrangements = Record.getArrangements(".");

        // Assert
        assertEquals(List.of("."), arrangements);
    }

    @Test
    public void getArrangements3() {
        // Act
        var arrangements = Record.getArrangements("#");

        // Assert
        assertEquals(List.of("#"), arrangements);
    }

    @Test
    public void getArrangements4() {
        // Act
        var arrangements = Record.getArrangements("?");

        // Assert
        assertEquals(List.of(".", "#"), arrangements);
    }
}
