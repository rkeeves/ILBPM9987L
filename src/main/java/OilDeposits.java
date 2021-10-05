import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class OilDeposits {

    // Wrong https://progcont.hu/submission/?id=514be388-6ef7-4987-8782-d494f16291b2
    // Wrong https://progcont.hu/submission/?id=28403012-8f55-4bf6-b151-e36f6de1dd7c
    // Pass  https://progcont.hu/submission/?id=5287de81-7219-40c4-8119-3768a669f7d6
    public static void main(String[] args) {
        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens;
            String line;
            int rowCount;
            int columnCount;
            int[][] board = new int[101][];
            int[] row;
            for (int i = 0; i < 101; i++) {
                board[i] = new int[101];
            }
            while (true) {
                tokens = br.readLine().split("\\s+");
                rowCount = Integer.parseInt(tokens[0]);
                if (rowCount < 1) {
                    return;
                }
                columnCount = Integer.parseInt(tokens[1]);
                for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                    line = br.readLine();
                    for (int colIndex = 0; colIndex < columnCount; colIndex++) {
                        board[rowIndex][colIndex] = line.charAt(colIndex) == '@' ? 1 : 0;
                    }
                }
                int nextColor = 2;
                for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                    row = board[rowIndex];
                    for (int colIndex = 0; colIndex < columnCount; colIndex++) {
                        if (row[colIndex] == 1) {
                            floodWithColor(board, rowCount, columnCount, rowIndex, colIndex, nextColor++);
                        }
                    }
                }
                bw.write(nextColor-2 + System.lineSeparator());
            }
        } catch (Exception e) {
            System.exit(13);
        }
    }

    static void floodWithColor(int[][] map, int rowCount, int colCount, int startRow, int startCol, int color) {
        if (map.length < 1 || map[0].length < 1) {
            return;
        }
        map[startRow][startCol] = color;
        Stack<Integer> rows = new Stack<>();
        Stack<Integer> cols = new Stack<>();
        rows.push(startRow);
        cols.push(startCol);
        Integer row;
        Integer col;
        while (!rows.empty()) {
            row = rows.pop();
            col = cols.pop();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    try {
                        int newRow = row+i;
                        int newCol = col+j;
                        if (map[row+i][col+j] == 1 && newRow < rowCount && newCol < colCount) {
                            map[row+i][col+j] = color;
                            rows.add(newRow);
                            cols.add(newCol);
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }
    }
}
