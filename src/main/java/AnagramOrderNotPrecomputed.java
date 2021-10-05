import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AnagramOrderNotPrecomputed {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            br.readLine();
            while (true) {
                char[] buff = br.readLine().toCharArray();
                quickSort(buff, 0, buff.length-1);
                do {
                    bw.write(buff);
                    bw.newLine();
                } while (nextPermutation(buff));
            }
        } catch (Exception e) {

        }
    }

    static void quickSort(char[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pi = partition(array, lo, hi);
        quickSort(array, lo, pi-1);
        quickSort(array, pi+1, hi);
    }

    static int DIFF = 'a'-'A';

    static int offsetOf(char c) {
        return c - 'A' - ((c / 'a') * DIFF);
    }

    static int indexOf(char c) {
        return (c - 'A' - ((c / 'a') * ('a'-'A'))) * 2 + (c / 'a');
    }

    static int partition(char[] array, int lo, int hi) {
        int pivot = indexOf(array[hi]);
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (indexOf(array[j]) < pivot) {
                swap(array, ++i, j);
            }
        }
        swap(array, ++i, hi);
        return i;
    }

    private static boolean nextPermutation(char[] data) {
        int pivot = data.length - 1;
        while (pivot > 0 && indexOf(data[pivot]) <= indexOf(data[pivot-1])) {
            pivot--;
        }
        pivot--;

        if (pivot < 0) {
            return false;
        }

        int right = data.length - 1;
        while (right > pivot && indexOf(data[pivot]) >= indexOf(data[right])) {
            right--;
        }

        swap(data, right, pivot);
        reverse(data, pivot + 1, data.length - 1);
        return true;
    }

    private static void swap(char[] data, int first, int second) {
        char t = data[second];
        data[second] = data[first];
        data[first] = t;
    }

    private static void reverse(char[] data, int start, int end) {
        while (start < end) {
            swap(data, start, end);
            start++;
            end--;
        }
    }
}
