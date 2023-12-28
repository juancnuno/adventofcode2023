package com.juancnuno.adventofcode2023.day07.test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2023.day07.FiveOfKind;
import com.juancnuno.adventofcode2023.day07.FourOfKind;
import com.juancnuno.adventofcode2023.day07.FullHouse;
import com.juancnuno.adventofcode2023.day07.Hand;
import com.juancnuno.adventofcode2023.day07.HighCard;
import com.juancnuno.adventofcode2023.day07.JsAreJacks;
import com.juancnuno.adventofcode2023.day07.JsAreJokers;
import com.juancnuno.adventofcode2023.day07.OnePair;
import com.juancnuno.adventofcode2023.day07.ThreeOfKind;
import com.juancnuno.adventofcode2023.day07.TwoPair;

public final class HandTest {

    @Test
    public void parse1() {
        // Act
        var hand = Hand.parse("AAAAA", JsAreJacks.INSTANCE);

        // Assert
        assertInstanceOf(FiveOfKind.class, hand);
    }

    @Test
    public void parse2() {
        // Act
        var hand = Hand.parse("AA8AA", JsAreJacks.INSTANCE);

        // Assert
        assertInstanceOf(FourOfKind.class, hand);
    }

    @Test
    public void parse3() {
        // Act
        var hand = Hand.parse("23332", JsAreJacks.INSTANCE);

        // Assert
        assertInstanceOf(FullHouse.class, hand);
    }

    @Test
    public void parse4() {
        // Act
        var hand = Hand.parse("TTT98", JsAreJacks.INSTANCE);

        // Assert
        assertInstanceOf(ThreeOfKind.class, hand);
    }

    @Test
    public void parse5() {
        // Act
        var hand = Hand.parse("23432", JsAreJacks.INSTANCE);

        // Assert
        assertInstanceOf(TwoPair.class, hand);
    }

    @Test
    public void parse6() {
        // Act
        var hand = Hand.parse("A23A4", JsAreJacks.INSTANCE);

        // Assert
        assertInstanceOf(OnePair.class, hand);
    }

    @Test
    public void parse7() {
        // Act
        var hand = Hand.parse("23456", JsAreJacks.INSTANCE);

        // Assert
        assertInstanceOf(HighCard.class, hand);
    }

    @Test
    public void parse8() {
        // Act
        var hand = Hand.parse("QJJQ2", JsAreJokers.INSTANCE);

        // Assert
        assertInstanceOf(FourOfKind.class, hand);
    }

    @Test
    public void compareTo1() {
        // Arrange
        var hand1 = Hand.parse("33332", JsAreJacks.INSTANCE);
        var hand2 = Hand.parse("2AAAA", JsAreJacks.INSTANCE);

        // Act
        var result = hand1.compareTo(hand2);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    public void compareTo2() {
        // Arrange
        var hand1 = Hand.parse("77888", JsAreJacks.INSTANCE);
        var hand2 = Hand.parse("77788", JsAreJacks.INSTANCE);

        // Act
        var result = hand1.compareTo(hand2);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    public void compareTo3() {
        // Arrange
        var hand1 = Hand.parse("JKKK2", JsAreJokers.INSTANCE);
        var hand2 = Hand.parse("QQQQ2", JsAreJokers.INSTANCE);

        // Act
        var result = hand1.compareTo(hand2);

        // Assert
        assertTrue(result < 0);
    }
}
