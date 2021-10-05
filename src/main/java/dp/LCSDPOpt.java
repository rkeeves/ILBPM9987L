package dp;

public class LCSDPOpt {


    public static int lcs3(String a, String b) {
        int[] arr = new int[b.length() + 1];
        char cha;
        int lastResult;
        int curr;
        for (int ai = 0; ai < a.length(); ai++) {
            cha = a.charAt(ai);
            lastResult = 0;
            for (int bi = 1; bi < arr.length; bi++) {
                curr = cha == b.charAt(bi - 1) ? arr[bi - 1] + 1 : Math.max(lastResult, arr[bi]);
                arr[bi - 1] = lastResult;
                lastResult = curr;
            }
            arr[arr.length - 1] = lastResult;
        }
        return arr[arr.length - 1];
    }

    public static int lcs(String a, String b) {
        int max = 0;
        int maxi = 0;
        int t;
        char ch;
        int bi;
        int li;
        for (int ai = 0; ai < a.length(); ai++) {
            ch = a.charAt(ai);
            for (li = 0; li < maxi && ch != b.charAt(li); li++) {
            }
            for (bi = maxi; bi < b.length() && ch != b.charAt(bi); bi++) {
            }
            if (li < maxi) {
                if (bi < b.length()) {
                    maxi = bi;
                    max++;
                } else {
                    maxi = li;
                }
            } else {
                if (bi < b.length()) {
                    maxi = bi;
                    max++;
                }
            }
            System.out.printf("[%d] %d %d%n", ai, maxi, max);
        }
        return max;
    }

    public static int lcs2(String a, String b) {

        for (int i = 0; i < a.length(); i++) {

            for (int j = 0; j < b.length(); j++) {
                System.out.printf("%d, ", (a.charAt(i) == b.charAt(j) ? 1 : 0));
            }
            System.out.println();
        }
        return 0;
    }

    public static int lcs4(String a, String b) {
        int li = 0;
        int ri = 0;
        char ch;
        int l = 0;
        for (int ai = 0; ai < a.length(); ai++) {
            ch = a.charAt(ai);
            int tli;

            int tri;
            for (tri = ri; tri < b.length() && ch != b.charAt(tri); tri++) {

            }
            if (tri < b.length()) {
                // []>
                System.out.println("[]>");
                for (tli = li; tli < ri && ch != b.charAt(tli); tli++) {

                }
                // <[]
                // >[]
                li = tli;
                ri = tri;
                l++;
                System.out.println("?>[]");
            } else {
                for (tri = li; tri < ri && ch != b.charAt(tri); tri++) {

                }
                ri = tri;
                System.out.println("[]<?");
                // []<?
                for (tli = li; tli >= 0 && ch != b.charAt(tli); tli--) {

                }
                if (tli >= 0) {
                    System.out.println("<[]");
                    li = tli;
                } else {
                    System.out.println("?>[]");
                }
            }
            System.out.printf("%d [%d-%d] %d %n", ai, li, ri, l);
        }
        return l;
    }
}
