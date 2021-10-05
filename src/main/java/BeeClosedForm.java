import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeeClosedForm {

    static final double R5 = Math.sqrt(5);

    static final double FIRST = (1.0 + R5) / 2.0;

    static final double SECOND = (1.0 - R5) / 2.0;

    // TLE https://progcont.hu/submission/?id=7a6096ae-f144-4284-a860-36db3170a648
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n;
            while (true) {
                n = Integer.parseInt(br.readLine());
                switch (n) {
                    case -1:  return;
                    case 0:
                        System.out.println("0 1");
                        break;
                    case 1:
                        System.out.println("1 2");
                        break;
                    default: {
                        System.out.printf("%d %d%n",
                                (long) ((Math.pow(FIRST, n+2) - Math.pow(SECOND, n+2)) / R5) - 1,
                                (long) ((Math.pow(FIRST, n+3) - Math.pow(SECOND, n+3)) / R5) - 1);
                    } break;
                }
            }
        } catch (IOException e) {

        }
    }
}