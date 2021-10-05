import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PermutationGenerator {

    static class DirectedInts {
        private final String original;
        private final int[] nums;
        private final boolean[] lefts;
        private final char[] buff;

        public DirectedInts(String original) {
            this.original=original;
            nums = IntStream.range(0, original.length()).toArray();
            lefts = new boolean[original.length()];
            Arrays.fill(lefts, true);
            buff = new char[original.length()];
        }

        public boolean next() {
            int idx = largestMobile();
            if (idx < 0) {
                System.out.println(original);
                return false;
            }
            int target = lefts[idx] ? idx-1 : idx+1;
            swap(idx, target);
            for (int i = 0; i < lefts.length; i++) {
                if (nums[i] > nums[target]) {
                    lefts[i] = !lefts[i];
                }

            }
            for (int i = 0; i < nums.length; i++) {
                buff[i] = original.charAt(nums[i]);
            }
            System.out.println(buff);
            return true;
        }

        private int largestMobile() {
            int idx = -1;
            int max = -1;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] == 0) || (i == 0 && lefts[i]) || ((i == nums.length - 1) && !lefts[i]) ){
                    continue;
                }
                if (lefts[i]) {
                    if (nums[i] > nums[i-1] && max < nums[i]) {
                        max = nums[i];
                        idx = i;
                    }
                } else {
                    if (nums[i] > nums[i+1] && max < nums[i]) {
                        max = nums[i];
                        idx = i;
                    }
                }
            }
            return idx;
        }

        private void swap(int i, int j) {
            int a = nums[i];
            nums[i] = nums[j];
            nums[j] = a;
            boolean b = lefts[i];
            lefts[i] = lefts[j];
            lefts[j] = b;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String word;
            boolean first = true;
            while ((word = br.readLine()) != null) {
                if (first) {
                    first = false;
                } else {
                    System.out.println();
                }
                permute(word);
            }
        } catch (Exception e) {

        }
    }

    static void permute(String word) {
        DirectedInts di = new DirectedInts(word);
        while (di.next()) {
        }
    }
}
