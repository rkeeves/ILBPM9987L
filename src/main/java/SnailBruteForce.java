import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://progcont.hu/progcont/100007/?pid=573
 */
public class SnailBruteForce {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens;
            Integer h, u, d, f, days;
            while (true) {
                tokens = br.readLine().split(" ");
                h = Integer.parseInt(tokens[0]);
                if (h == 0) {
                    break;
                }
                u = Integer.parseInt(tokens[1]);
                d = Integer.parseInt(tokens[2]);
                f = Integer.parseInt(tokens[3]);
                days = solveByBruteForce(h, u, d, f);
                if (days >= 0) {
                    System.out.printf("success on day %d%n", days);
                } else {
                    System.out.printf("failure on day %d%n", -days);
                }
            }
        }
    }

    static int solveByBruteForce(int h, int u, int d, int f) {
        int hs = h * 100;
        int us = u * 100;
        int ds = d * 100;
        int fs = u * f;
        int x = 0;
        int dx = us + fs;
        for (int day = 1;;day++) {
            dx = Math.max(0, dx - fs);
            x += dx;
            if (x > hs) {
                return day;
            }
            x -= ds;
            if (x < 0) {
                return -day;
            }
        }
    }
}
