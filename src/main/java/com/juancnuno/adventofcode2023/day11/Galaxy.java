package com.juancnuno.adventofcode2023.day11;

public record Galaxy(int rowIndex, int columnIndex) {

    Galaxy incrementRowIndex() {
        return new Galaxy(rowIndex + 1, columnIndex);
    }

    Galaxy incrementColumnIndex() {
        return new Galaxy(rowIndex, columnIndex + 1);
    }

    public int distance(Galaxy galaxy) {
        return Math.abs(rowIndex - galaxy.rowIndex) + Math.abs(columnIndex - galaxy.columnIndex);
    }
}
