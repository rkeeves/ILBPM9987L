package dp;

public class MaxSubarray1DBrute {

    public static int maxSubarray(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
