package com.juancnuno.adventofcode2023.day12.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day12.Record;

public final class RecordTest {

    @Test
    public void getArrangementCount1() {
        // Arrange
        var record = Record.from("???.### 1,1,3");

        // Act
        var count = record.getArrangementCount();

        // Assert
        assertEquals(1, count);
    }

    @Test
    public void getArrangementCount2() {
        // Arrange
        var record = Record.from(".??..??...?##. 1,1,3");

        // Act
        var count = record.getArrangementCount();

        // Assert
        assertEquals(4, count);
    }

    @Test
    public void getArrangementCount3() {
        // Arrange
        var record = Record.from("?#?#?#?#?#?#?#? 1,3,1,6");

        // Act
        var count = record.getArrangementCount();

        // Assert
        assertEquals(1, count);
    }

    @Test
    public void getArrangementCount4() {
        // Arrange
        var record = Record.from("????.#...#... 4,1,1");

        // Act
        var count = record.getArrangementCount();

        // Assert
        assertEquals(1, count);
    }

    @Test
    public void getArrangementCount5() {
        // Arrange
        var record = Record.from("????.######..#####. 1,6,5");

        // Act
        var count = record.getArrangementCount();

        // Assert
        assertEquals(4, count);
    }

    @Test
    public void getArrangementCount6() {
        // Arrange
        var record = Record.from("?###???????? 3,2,1");

        // Act
        var count = record.getArrangementCount();

        // Assert
        assertEquals(10, count);
    }

    @Test
    public void unfold() {
        // Arrange
        var record = Record.from(".# 1");

        // Act
        var actual = record.unfold();

        // Assert
        assertEquals(Record.from(".#?.#?.#?.#?.# 1,1,1,1,1"), actual);
    }
}
