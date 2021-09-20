import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://progcont.hu/progcont/100127/?pid=10405
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String a;
            String b;
            while ((a = br.readLine()) != null && (b = br.readLine()) != null) {
                System.out.println(lcs(a,b));
            }
        } catch (Exception e) {

        }
    }

    public static int lcs(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        int[] arr = new int[b.length()+1];
        char cha;
        int lastResult;
        int curr;
        for (int ai = 0; ai < a.length(); ai++) {
            cha = a.charAt(ai);
            lastResult = 0;
            for (int bi = 1; bi < arr.length; bi++) {
                curr = cha == b.charAt(bi-1) ? arr[bi-1] + 1 : Math.max(lastResult, arr[bi]);
                arr[bi-1] = lastResult;
                lastResult = curr;
            }
            arr[arr.length-1] = lastResult;
        }
        return arr[arr.length-1];
    }
}
