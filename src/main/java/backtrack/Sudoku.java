package backtrack;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Sudoku {

    static class Cell {

        private final int row;

        private final int col;

        private final BitSet numbers;

        public Cell(int row, int col, BitSet numbers) {
            this.row = row;
            this.col = col;
            this.numbers = numbers;
        }

        public int cardinality() {
            return numbers.cardinality();
        }
    }

    static class SudokuTable {

        private final Cell[][] cells;

        private final List<Cell> cellList;

        private final int[][] solution;

        SudokuTable() {
            this.cells = new Cell[9][];
            for (int i = 0; i < 9; i++) {
                this.cells[i] = new Cell[9];
                for (int j = 0; j < 9; j++) {
                    BitSet bs = new BitSet(9);
                    bs.flip(0,9);
                    this.cells[i][j] = new Cell(i, j, bs);
                }
            }
            this.cellList = Arrays.stream(cells)
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
            this.solution = new int[9][];
            for (int i = 0; i < solution.length; i++) {
                solution[i] = new int[9];
            }
        }

        boolean hasNextStep() {
            return !cellList.isEmpty() && cellList.get(0).numbers.cardinality() == 1;
        }

        void nextStep() {
            Cell cell = cellList.get(0);
            int idxToSet = cell.numbers.nextSetBit(0);
            setCell(cell.row, cell.col, idxToSet);
        }

        private void setCell(int row, int col, int idxToSet) {
            Cell currentCell = cells[row][col];
            forEachInSameRow(row, (cell)->cell.numbers.set(idxToSet, false));
            forEachInSameColumn(col, (cell)->cell.numbers.set(idxToSet, false));
            forEachInSameSubGrid(row, col, (cell)->cell.numbers.set(idxToSet, false));
            cellList.remove(currentCell);
            cellList.sort(Comparator.comparingInt(Cell::cardinality));
            this.solution[row][col] = idxToSet+1;
        }

        private void forEachInSameRow(int row, Consumer<Cell> sideEffect) {
            for (int i = 0; i < cells.length; i++) {
                sideEffect.accept(cells[row][i]);
            }
        }

        private void forEachInSameColumn(int column, Consumer<Cell> sideEffect) {
            for (int i = 0; i < cells.length; i++) {
                sideEffect.accept(cells[i][column]);
            }
        }

        private void forEachInSameSubGrid(int row, int column, Consumer<Cell> sideEffect) {
            int startRow = row - row % 3;
            int startColumn = column - column % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sideEffect.accept(cells[startRow+i][startColumn+j]);
                }
            }
        }

        int[][] getSolution() {
            return solution;
        }
    }

    public static int[][] solveSudoku(int[][] board) {
        SudokuTable table = new SudokuTable();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > 0) {
                    table.setCell(i, j, board[i][j] - 1);
                }
            }
        }
        for (int i = 0; table.hasNextStep(); i++) {
            table.nextStep();
        }
        return table.getSolution();
    }
}
