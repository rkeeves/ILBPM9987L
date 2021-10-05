import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

// https://progcont.hu/progcont/100364/?locale=hu&pid=10063
// TLE https://progcont.hu/submission/?id=8c8aa611-c75a-4f1e-8e88-e4dfae2cd7e6
public class PermutationGeneratorImproved {

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
        permute(word.split(""), 0, new LinkedList<>());
    }

    private static void permute(String[] chars, int current, List<String> accu) {
        if (current >= chars.length) {
            System.out.println(String.join("",accu));
            return;
        }
        for (int i = 0; i <= accu.size(); i++) {
            accu.add(i, chars[current]);
            permute(chars, current+1, accu);
            accu.remove(i);
        }
    }

    static void permute2(String word) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        permute2(word.split(""), 0, new LinkedList<>(), sj);
        System.out.println(sj.toString());
    }

    private static void permute2(String[] chars, int current, List<String> accu, StringJoiner sj) {
        if (current >= chars.length) {
            sj.add(String.join("",accu));
            return;
        }
        for (int i = 0; i <= accu.size(); i++) {
            accu.add(i, chars[current]);
            permute2(chars, current+1, accu, sj);
            accu.remove(i);
        }
    }
}
