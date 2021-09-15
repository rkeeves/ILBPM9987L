import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnailConstO {

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
                days = solveByConst(h, u, d, f);
                if (days >= 0) {
                    System.out.printf("success on day %d%n", days);
                } else {
                    System.out.printf("failure on day %d%n", -days);
                }
            }
        }
    }

    interface DblFunc {
        double y(double x);
    }

    static int solveByConst(int h, int u, int d, int f) {
        if (u > h) {
            return 1;
        }
        if (d > u) {
            return -1;
        }
        double x, y;
        final double hs = h * 100.0;
        final double us = u * 100.0;
        final double ds = d * 100.0;
        final double fs = f * u;
        DblFunc psMidDay = (day) -> -fs/2 * day * day + (us - ds + (fs / 2.0)) * day + ds;
        DblFunc psEndDay = (day) -> psMidDay.y(day) - ds;
        double peakX = (us - ds) / fs + 1.0;
        double breakX = us / fs + 1.0;
        // Try [1,peak[
        if (peakX > 1) {
            x = Math.floor(peakX);
            y = psMidDay.y(x);
            if (y > hs) {
                x = solveQuadratic(-fs/2,us - ds + (fs / 2.0),ds, hs+0.1)[0];
                if (x > 1 && x < peakX) {
                    return (int) Math.ceil(x);
                }
            }
            x = Math.ceil(peakX);
            y = psMidDay.y(x);
            if (y > hs) {
                return (int) x;
            }
        }
        // Try [peak,breakFloor[
        double q0x = solveQuadratic(-fs/2,us - ds + (fs / 2.0),0, -0.1)[1];
        if (q0x <= Math.floor(breakX)) {
            return (int) -Math.ceil(q0x);
        }
        // Solve [breakFloor, breakCeil]
        double breakFloorX = Math.floor(breakX);
        double breakCeilX = Math.ceil(breakX);
        double breakFloorY = psEndDay.y(breakFloorX);
        double breakCeilY = (breakFloorX == breakCeilX) ? psEndDay.y(breakFloorX) : breakFloorY - ds;
        if (breakFloorY < 0) {
            return (int) -breakFloorX;
        }
        x = Math.ceil(breakX);
        if (breakCeilY < 0) {
            return (int) -breakCeilX;
        }
        double pos = breakCeilY;
        return (int) -((pos / ds) + 1.0 + breakCeilX);
    }

    private static double[] solveQuadratic(double a2, double a1, double a0, double target) {
        double discriminant = a1*a1 - 4.0*a2*(a0-target);
        double denom = 2 * a2;
        if (discriminant >= 0) {
            double discriminantSqRoot = Math.sqrt(discriminant);
            return new double[]{(-a1 + discriminantSqRoot)/denom, (-a1 - discriminantSqRoot)/denom};
        } else {
            return new double[]{Double.NaN, Double.NaN};
        }
    }
}
