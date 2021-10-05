import java.io.*;

public class BeeClosedFormCached {

    static final double R5 = Math.sqrt(5);

    static final double FIRST = (1.0 + R5) / 2.0;

    static final double SECOND = (1.0 - R5) / 2.0;

    public static void main(String[] args) {
        long[] cache = new long[47];
        cache[0] = 0L;
        cache[1] = 1L;
        // Mr. Closed Form Solution wants to get into the progcont party too,
        // but he has to do it in secret, so he took up a little disguise...
        for (int i = 2; i < cache.length; i++) {
            cache[i] = (long) ((Math.pow(FIRST, i+2) - Math.pow(SECOND, i+2)) / R5) - 1;
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
