import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BeeArrayCached {

    // https://progcont.hu/submission/?id=73de9f4c-73a3-49bb-a38c-a7e41b57b822
    public static void main(String[] args) {
        long[] cache = new long[47];
        cache[0] = 0L;
        cache[1] = 1L;
        for (int i = 2; i < cache.length; i++) {
            cache[i] = cache[i-2] + cache[i-1] + 1;
        }
        String[] messageCache = new String[47];
        int len = cache.length - 1;
        for (int i = 0; i < len; i++) {
            messageCache[i] = String.format("%d %d%n",cache[i], cache[i+1]);
        }
        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                bw.write(messageCache[Integer.parseInt(br.readLine())]);
            }
        } catch (Exception e) {

        }
    }
}
