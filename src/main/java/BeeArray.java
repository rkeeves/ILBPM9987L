import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BeeArray {

    // TLE https://progcont.hu/submission/?id=b43e16c9-957f-43d2-9912-654973abe2a6
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long[] cache = new long[47];
            cache[0] = 0L;
            cache[1] = 1L;
            for (int i = 2; i < cache.length; i++) {
                cache[i] = cache[i-2] + cache[i-1] + 1;
            }
            int n;
            while (true) {
                n = Integer.parseInt(br.readLine());
                System.out.printf("%d %d%n",cache[n], cache[n+1]);
            }
        } catch (Exception e) {

        }
    }
}
