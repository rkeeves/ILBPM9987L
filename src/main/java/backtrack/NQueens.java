package backtrack;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NQueens {

    public static void main(String[] args) {
        solveNQueens(5);
    }
    public static void solveNQueens(int n) {
        int[][] board = createBoard(n);
        solveNQueens(0, board);
    }

    private static int[][] createBoard(int n) {
        int[][] board = new int[n][];
        for (int i = 0; i < board.length; i++) {
            board[i] = new int[n];
        }
        return board;
    }

    private static void solveNQueens(int column, int[][] board) {
        if (column >= board.length) {
            print(board);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isPossible(board, row, column)) {
                board[row][column] = 1;
                solveNQueens(column+1, board);
                board[row][column] = 0;
            }
        }
    }

    private static boolean isPossible(int[][] board, int row, int column) {
        final int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[row][i] != 0) {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] != 0) {
                return false;
            }
        }
        for (int i = row, j = column; i < n && j >= 0; i++, j--) {
            if (board[i][j] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[][] board) {
        var msg = Arrays.stream(board)
                .map(row -> Arrays.stream(row).
                        mapToObj(Integer::toString)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println("##");
        System.out.println(msg);
    }
}
