package dp;

public class LCSDP {

    public static int lcs(String a, String b) {
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
