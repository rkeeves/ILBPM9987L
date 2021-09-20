package backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    @Test
    void test() {
        int[][] board = new int[][]{
                {4,0,6,5,0,2,8,0,9},
                {0,0,0,0,4,0,0,3,0},
                {0,0,0,0,0,0,0,0,5},
                {6,0,0,8,0,0,1,0,0},
                {5,0,0,0,7,0,0,8,0},
                {3,0,2,9,0,4,0,6,0},
                {0,2,0,6,0,0,0,0,1},
                {0,0,0,0,5,3,9,4,0},
                {8,3,0,0,9,0,0,0,2}
        };
        int[][] expected = new int[][]{
                {4,7,6,5,3,2,8,1,9},
                {2,5,8,1,4,9,7,3,6},
                {1,9,3,7,6,8,4,2,5},
                {6,4,7,8,2,5,1,9,3},
                {5,1,9,3,7,6,2,8,4},
                {3,8,2,9,1,4,5,6,7},
                {9,2,4,6,8,7,3,5,1},
                {7,6,1,2,5,3,9,4,8},
                {8,3,5,4,9,1,6,7,2}
        };
        int[][] actual = Sudoku.solveSudoku(board);
        assertArrayEquals(expected, actual);
    }

}