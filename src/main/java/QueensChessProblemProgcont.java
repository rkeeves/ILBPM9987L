import java.io.*;
import java.util.Arrays;

public class QueensChessProblemProgcont {

    static int counter;

    static int[] placements = new int[9];

    public static void main(String[] args) {
        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens;
            int caseCount = Integer.parseInt(br.readLine());
            boolean first = true;
            for (int i = 0; i < caseCount; i++) {
                if (first) {
                    first = false;
                } else {
                    bw.newLine();
                }
                counter = 1;
                tokens = br.readLine().split("\\s+");
                Arrays.fill(placements, 0);
                placements[Integer.parseInt(tokens[1])] = Integer.parseInt(tokens[0]);
                bw.write("SOLN       COLUMN"+System.lineSeparator());
                bw.write(" #      1 2 3 4 5 6 7 8"+System.lineSeparator()+System.lineSeparator());
                generateCases(1, bw);
            }
        } catch (Exception e) {
            System.exit(13);
        }
    }

    static void generateCases(int currentRow, BufferedWriter bw) throws IOException {
        if (currentRow == 9) {
            bw.write(String.format("%2d      %d %d %d %d %d %d %d %d%n", counter++, placements[1], placements[2], placements[3], placements[4], placements[5], placements[6], placements[7], placements[8]));
            return;
        }
        if (placements[currentRow] != 0) {
            generateCases(currentRow+1, bw);
            return;
        }
        for (int currentCol = 1; currentCol < 9; currentCol++) {
            boolean valid = true;
            for (int enemyRow = 1; enemyRow < 9; enemyRow++) {
                int enemyCol = placements[enemyRow];
                if (enemyCol > 0 &&
                        (enemyCol == currentCol || Math.abs(enemyRow - currentRow) == Math.abs(enemyCol - currentCol))) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                placements[currentRow] = currentCol;
                generateCases(currentRow+1, bw);
                placements[currentRow] = 0;
            }
        }
    }
}
