package com.juancnuno.adventofcode2023.day11;

record Galaxy(int rowIndex, int columnIndex) {

    Galaxy incrementRowIndex() {
        return new Galaxy(rowIndex + 1, columnIndex);
    }

    Galaxy incrementColumnIndex() {
        return new Galaxy(rowIndex, columnIndex + 1);
    }
}
