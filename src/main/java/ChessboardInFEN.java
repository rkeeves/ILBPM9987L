import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ChessboardInFEN {

    static class Board {

        private final char[][] board;

        interface BoardSideEffect {
            void effect(int row, int col);
        }

        private final BoardSideEffect[] sideEffects = new BoardSideEffect[115];

        public Board() {
            board = new char[8][];
            for (int i = 0; i < 8; i++) {
                board[i] = new char[8];
            }
            sideEffects['X'] = this::noop;
            sideEffects[' '] = this::noop;
            sideEffects['p'] = this::pawnBlack;
            sideEffects['n'] = this::knight;
            sideEffects['b'] = this::bishop;
            sideEffects['r'] = this::rook;
            sideEffects['q'] = this::queen;
            sideEffects['k'] = this::king;
            sideEffects['P'] = this::pawnWhite;
            sideEffects['N'] = this::knight;
            sideEffects['B'] = this::bishop;
            sideEffects['R'] = this::rook;
            sideEffects['Q'] = this::queen;
            sideEffects['K'] = this::king;
        }

        void place(char pieceCode, int r, int c) {
            board[r][c] = pieceCode;
        }

        void clear() {
            for (char[] row : board) {
                Arrays.fill(row, ' ');
            }
        }

        int countUnoccupiedNotThreatened() {
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    sideEffects[board[r][c]].effect(r,c);
                }
            }
            int res = 0;
            for (char[] row : board) {
                for (char cell : row) {
                    res += cell == ' ' ? 1 : 0;
                }
            }
            return res;
        }

        private void noop(int r, int c) {
            // noop
        }

        private static final int[][] pawnWhitePattern = new int[][]{{ -1, -1}, {-1, 1}};

        private void pawnWhite(int r, int c) {
            lightUpPoints(r, c, pawnWhitePattern);
        }

        private static final int[][] pawnBlackPattern = new int[][]{{ 1, -1}, { 1, 1}};

        private void pawnBlack(int r, int c) {
            lightUpPoints(r, c, pawnBlackPattern);
        }

        private static final int[][] knightPattern = new int[][]{{ 2, 1}, { 2,-1}, { 1, 2}, { 1,-2}, {-1, 2}, {-1,-2}, {-2, 1}, {-2,-1}};

        private void knight(int r, int c) {
            lightUpPoints(r, c, knightPattern);
        }

        private static final int[][] kingPattern = new int[][]{{-1,-1}, { 0,-1}, { 1,-1}, {-1, 0}, { 1, 0}, {-1, 1}, { 0, 1}, { 1, 1}};

        private void king(int r, int c) {
            lightUpPoints(r, c, kingPattern);
        }

        private void lightUpPoints(int srcRow, int srcCol, int[][] deltaRowColPairs) {
            try {
                for (int[] deltaRowColPair : deltaRowColPairs) {
                    try {
                        if (board[srcRow+deltaRowColPair[0]][srcCol+deltaRowColPair[1]] == ' ') {
                            board[srcRow+deltaRowColPair[0]][srcCol+deltaRowColPair[1]] = 'X';
                        }
                    } catch (Exception e) {

                    }
                }
            } catch (Exception e) {

            }
        }

        private void bishop(int r, int c) {
            castRay(r,c, 1, 1);
            castRay(r,c, 1,-1);
            castRay(r,c,-1, 1);
            castRay(r,c,-1,-1);
        }

        private void rook(int r, int c) {
            castRay(r,c, 0, 1);
            castRay(r,c, 0,-1);
            castRay(r,c, 1, 0);
            castRay(r,c,-1, 0);
        }

        private void queen(int r, int c) {
            bishop(r,c);
            rook(r,c);
        }

        private void castRay(int srcRow, int srcCol, int deltaRow, int deltaCol) {
            try {
                for (srcRow += deltaRow, srcCol += deltaCol;board[srcRow][srcCol] == ' ' || board[srcRow][srcCol] == 'X';srcRow += deltaRow, srcCol += deltaCol) {
                    board[srcRow][srcCol] = 'X';
                }
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] fenRows;
            while (true) {
                board.clear();
                fenRows = br.readLine().split("/");
                for (int row = 0; row < 8; row++) {
                    int col = 0;
                    for (char ch : fenRows[row].toCharArray()) {
                        if (ch - 65 < 0) {
                            col += ch - '0';
                        } else {
                            board.place(ch, row, col++);
                        }
                    }
                }
                bw.write(board.countUnoccupiedNotThreatened() + System.lineSeparator());
            }
        } catch (Exception e) {

        }
    }
}
