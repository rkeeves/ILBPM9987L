import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://progcont.hu/progcont/100067/?pid=4898
public class EditDistanceDPFullMatrix {

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
        int[][] arr = new int[lenA][];
        for (int i = 0; i < lenA; i++) {
            arr[i] = new int[lenB];
        }
        for (int i = 0; i < lenB; i++) {
            arr[0][i] = i;
        }
        for (int i = 0; i < lenA; i++) {
            arr[i][0] = i;
        }
        char cha;
        int subst;
        for (int ai = 1; ai < lenA; ai++) {
            cha = Character.toLowerCase(a.charAt(ai-1));
            for (int bi = 1; bi < lenB; bi++) {
                subst = cha != Character.toLowerCase(b.charAt(bi-1)) ? 1 : 0;
                arr[ai][bi] = Math.min(
                        Math.min(
                                arr[ai-1][bi]+1,
                                arr[ai][bi-1]+1),
                        arr[ai-1][bi-1]+subst);
            }
        }
        return arr[lenA-1][lenB-1];
    }
}
