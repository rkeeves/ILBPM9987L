package dp;

public class LCSRec {

    public static int lcs(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        return lcs(a, 0, b, 0);
    }

    private static int lcs(String a, int ai, String b, int bi) {
        if (ai == a.length() || bi == b.length()) {
            return 0;
        }
        if (a.charAt(ai) == b.charAt(bi)) {
            return 1 + lcs(a, ai+1, b, bi+1);
        } else {
            return Math.max(
                    lcs(a, ai, b, bi+1),
                    lcs(a, ai+1, b, bi)
            );
        }
    }
}
