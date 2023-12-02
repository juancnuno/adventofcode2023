package com.juancnuno.adventofcode2023.day01.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day01.SearchResult;

public final class SearchResultTest {

    @Test
    public void getFirstDigit1() {
        // Act
        var digit = SearchResult.getFirstDigit("two1nine");

        // Assert
        assertEquals(2, digit);
    }

    @Test
    public void getFirstDigit2() {
        // Act
        var digit = SearchResult.getFirstDigit("eightwothree");

        // Assert
        assertEquals(8, digit);
    }

    @Test
    public void getFirstDigit3() {
        // Act
        var digit = SearchResult.getFirstDigit("abcone2threexyz");

        // Assert
        assertEquals(1, digit);
    }

    @Test
    public void getFirstDigit4() {
        // Act
        var digit = SearchResult.getFirstDigit("xtwone3four");

        // Assert
        assertEquals(2, digit);
    }

    @Test
    public void getFirstDigit5() {
        // Act
        var digit = SearchResult.getFirstDigit("4nineeightseven2");

        // Assert
        assertEquals(4, digit);
    }

    @Test
    public void getFirstDigit6() {
        // Act
        var digit = SearchResult.getFirstDigit("zoneight234");

        // Assert
        assertEquals(1, digit);
    }

    @Test
    public void getFirstDigit7() {
        // Act
        var digit = SearchResult.getFirstDigit("7pqrstsixteen");

        // Assert
        assertEquals(7, digit);
    }

    @Test
    public void getLastDigit1() {
        // Act
        var digit = SearchResult.getLastDigit("two1nine");

        // Assert
        assertEquals(9, digit);
    }

    @Test
    public void getLastDigit2() {
        // Act
        var digit = SearchResult.getLastDigit("eightwothree");

        // Assert
        assertEquals(3, digit);
    }

    @Test
    public void getLastDigit3() {
        // Act
        var digit = SearchResult.getLastDigit("abcone2threexyz");

        // Assert
        assertEquals(3, digit);
    }

    @Test
    public void getLastDigit4() {
        // Act
        var digit = SearchResult.getLastDigit("xtwone3four");

        // Assert
        assertEquals(4, digit);
    }

    @Test
    public void getLastDigit5() {
        // Act
        var digit = SearchResult.getLastDigit("4nineeightseven2");

        // Assert
        assertEquals(2, digit);
    }

    @Test
    public void getLastDigit6() {
        // Act
        var digit = SearchResult.getLastDigit("zoneight234");

        // Assert
        assertEquals(4, digit);
    }

    @Test
    public void getLastDigit7() {
        // Act
        var digit = SearchResult.getLastDigit("7pqrstsixteen");

        // Assert
        assertEquals(6, digit);
    }
}
