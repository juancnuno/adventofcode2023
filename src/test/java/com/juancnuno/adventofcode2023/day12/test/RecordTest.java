package com.juancnuno.adventofcode2023.day12.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day12.Record;

public final class RecordTest {

    @Test
    public void getArrangementCount() {
        // Arrange
        var record = new Record("???.### 1,1,3");

        // Act
        var count = record.getArrangementCount();

        // Assert
        assertEquals(1, count);
    }
}
