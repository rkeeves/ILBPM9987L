package dp;

public class MaxSubarray1DDC {

    public static int maxSubarray(int[] arr) {
        return maxSubarray(arr, 0, arr.length-1);
    }

    private static int maxSubarray(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return arr[lo];
        }
        int m = lo + (hi - lo) / 2;
        return Math.max(
                Math.max(
                    maxSubarray(arr, lo, m),
                    maxSubarray(arr, m+1, hi)),
                maxCross(arr, lo, m, hi));
    }

    private static int maxCross(int[] arr, int lo, int m, int hi) {
        int leftSumMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = m; i >= lo; i--) {
            sum += arr[i];
            if (sum > leftSumMax) {
                leftSumMax = sum;
            }
        }
        int rightSumMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = m + 1; i <= hi; i++) {
            sum += arr[i];
            if (sum > rightSumMax) {
                rightSumMax = sum;
            }
        }
        return Math.max(leftSumMax + rightSumMax, Math.max(leftSumMax, rightSumMax));
    }
}
