package com.juancnuno.adventofcode2023.day11;

public record Galaxy(int rowIndex, int columnIndex) {

    Galaxy incrementRowIndex(int amount) {
        return new Galaxy(rowIndex + amount, columnIndex);
    }

    Galaxy incrementColumnIndex(int amount) {
        return new Galaxy(rowIndex, columnIndex + amount);
    }

    public int distance(Galaxy galaxy) {
        return Math.abs(rowIndex - galaxy.rowIndex) + Math.abs(columnIndex - galaxy.columnIndex);
    }
}
