import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EditDistanceDPTwoRowsOnly {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens;
            int lineCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < lineCount; i++) {
                tokens = br.readLine().split(" ");
                System.out.printf("%d. Edit Distance = %d%n", (i+1), editDistance(tokens[0], tokens[1]));
            }
        } catch (Exception e) {

        }
    }

    static int editDistance(String a, String b) {
        if (a.isEmpty()) {
            return b.length();
        }
        if (b.isEmpty()) {
            return a.length();
        }
        int lenA = a.length()+1;
        int lenB = b.length()+1;
        int[] t;
        int[] last = new int[lenB];
        for (int i = 0; i < last.length; i++) {
            last[i] = i;
        }
        int[] curr = new int[lenB];
        char cha;
        int subst;
        for (int ai = 1; ai < lenA; ai++) {
            cha = Character.toLowerCase(a.charAt(ai-1));
            curr[0] = ai;
            for (int bi = 1; bi < lenB; bi++) {
                subst = cha != Character.toLowerCase(b.charAt(bi-1)) ? 1 : 0;
                curr[bi] = Math.min(Math.min(last[bi]+1, curr[bi-1]+1), last[bi-1]+subst);
            }
            t = last;
            last = curr;
            curr = t;
        }
        return last[last.length-1];
    }
}
