import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AncientMessages {

    static final int[][] arr;
    static final String[] patchCountToSymbol;
    static {
        arr = new int[103][];
        arr['0'] = new int[]{0,0,0,0};
        arr['1'] = new int[]{0,0,0,2};
        arr['2'] = new int[]{0,0,2,0};
        arr['3'] = new int[]{0,0,2,2};
        arr['4'] = new int[]{0,2,0,0};
        arr['5'] = new int[]{0,2,0,2};
        arr['6'] = new int[]{0,2,2,0};
        arr['7'] = new int[]{0,2,2,2};
        arr['8'] = new int[]{2,0,0,0};
        arr['9'] = new int[]{2,0,0,2};
        arr['a'] = new int[]{2,0,2,0};
        arr['b'] = new int[]{2,0,2,2};
        arr['c'] = new int[]{2,2,0,0};
        arr['d'] = new int[]{2,2,0,2};
        arr['e'] = new int[]{2,2,2,0};
        arr['f'] = new int[]{2,2,2,2};
        patchCountToSymbol = new String[20];
        Arrays.fill(patchCountToSymbol, "?");
        patchCountToSymbol[1] = "A";
        patchCountToSymbol[3] = "J";
        patchCountToSymbol[5] = "D";
        patchCountToSymbol[4] = "S";
        patchCountToSymbol[0] = "W";
        patchCountToSymbol[2] = "K";
    }

    public static void main(String[] args) {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens;
            int h;
            int wHexChars;
            int w;
            int[][] canvas;
            int caseNumber = 0;
            while (true) {
                tokens = br.readLine().split("\\s+");
                h = Integer.parseInt(tokens[0]);
                wHexChars = Integer.parseInt(tokens[1]);
                w = wHexChars * 4;
                if (h == 0) {
                    return;
                }
                canvas = new int[h+2][];
                canvas[0] = new int[wHexChars*4+2];
                Arrays.fill(canvas[0], 0);
                canvas[canvas.length-1] = new int[wHexChars*4+2];
                Arrays.fill(canvas[canvas.length-1], 0);
                for (int row = 1; row < h+1; row++) {
                    canvas[row] = new int[wHexChars*4+2];
                    canvas[row][0] = 0;
                    canvas[row][wHexChars*4+1] = 0;
                    String line = br.readLine();
                    for (int col = 0; col < wHexChars; col++) {
                        System.arraycopy(arr[line.charAt(col)],0,canvas[row],col*4+1,4);
                    }
                }
                floodWithColor(canvas, 0, 0, 0, 1);
                List<String> symbols = new ArrayList<>();
                int rows = canvas.length;
                int cols = canvas[0].length;
                for (int row = 0; row < rows;row++) {
                    for (int col = 0; col < cols; col++) {
                        if (canvas[row][col] == 2) {
                            symbols.add(patchCountToSymbol[countPatches(canvas, row, col)]);
                        }
                    }
                }
                Collections.sort(symbols);
                System.out.printf("Case %d: %s%n", ++caseNumber, String.join("", symbols));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int countPatches(int[][] canvas, int row0, int col0) {
        int patchCount = 0;
        canvas[row0][col0] = 3;
        Stack<Integer> rows = new Stack<>();
        Stack<Integer> cols = new Stack<>();
        rows.push(row0);
        cols.push(col0);
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
                        if (canvas[newRow][newCol] == 0) {
                            patchCount++;
                            floodWithColor(canvas, newRow, newCol, 0, 3);
                        }
                    } catch (Exception e) {

                    }
                }
            }
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    try {
                        int newRow = row+i;
                        int newCol = col+j;
                        if (canvas[row+i][col+j] == 2) {
                            canvas[row+i][col+j] = 3;
                            rows.add(newRow);
                            cols.add(newCol);
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }
        return patchCount;
    }

    static void floodWithColor(int[][] canvas, int row0, int col0, int oldColor, int newColor) {
        canvas[row0][col0] = newColor;
        Stack<Integer> rows = new Stack<>();
        Stack<Integer> cols = new Stack<>();
        rows.push(row0);
        cols.push(col0);
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
                        if (canvas[row+i][col+j] == oldColor) {
                            canvas[row+i][col+j] = newColor;
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
