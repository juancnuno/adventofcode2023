package com.juancnuno.adventofcode2023.day12.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day12.Part1;

public final class Part1Test {

    @Test
    public void getArrangementCountSum() {
        // Arrange
        var string = """
            ???.### 1,1,3
            .??..??...?##. 1,1,3
            ?#?#?#?#?#?#?#? 1,3,1,6
            ????.#...#... 4,1,1
            ????.######..#####. 1,6,5
            ?###???????? 3,2,1
            """;

        var stream = string.lines();

        // Act
        var sum = Part1.getArrangementCountSum(stream);

        // Assert
        assertEquals(21, sum);
    }
}
