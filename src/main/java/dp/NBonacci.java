package dp;

import java.util.stream.IntStream;

public class NBonacci {

    public static int nBonacciNoSum(int[] baseCases, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N must be greater than or equal to 0");
        }
        int l = baseCases.length;
        if (n < l) {
            return baseCases[n];
        }
        int i;
        int sum = IntStream.of(baseCases).sum();
        for (i = l; i <= n; i++) {
            sum = (sum << 1) - baseCases[i % l];
            baseCases[i % l] = (sum + baseCases[i % l]) >> 1;
        }
        return baseCases[(i - 1) % l];
    }

    public static int nBonacciWithSum(int[] baseCases, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N must be greater than or equal to 0");
        }
        if (n < baseCases.length) {
            return baseCases[n];
        }
        int i;
        for (i = baseCases.length; i <= n; i++) {
            baseCases[i % baseCases.length] = IntStream.of(baseCases).sum();
        }
        return baseCases[(i - 1) % baseCases.length];
    }
}
