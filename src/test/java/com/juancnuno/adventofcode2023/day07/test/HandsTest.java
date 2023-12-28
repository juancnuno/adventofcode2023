package com.juancnuno.adventofcode2023.day07.test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day07.Hands;
import com.juancnuno.adventofcode2023.day07.JsAreJacks;
import com.juancnuno.adventofcode2023.day07.JsAreJokers;

public final class HandsTest {

    private static final String LINES = """
        32T3K 765
        T55J5 684
        KK677 28
        KTJJT 220
        QQQJA 483
        """;

    private final Stream<String> lines = LINES.lines();

    @Test
    public void getTotalWinnings1() {
        // Act
        var winnings = Hands.getTotalWinnings(lines, JsAreJacks.INSTANCE);

        // Assert
        assertEquals(6_440, winnings);
    }

    @Test
    public void getTotalWinnings2() {
        // Act
        var winnings = Hands.getTotalWinnings(lines, JsAreJokers.INSTANCE);

        // Assert
        assertEquals(5_905, winnings);
    }
}
