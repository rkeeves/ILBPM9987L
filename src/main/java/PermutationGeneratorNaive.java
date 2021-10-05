import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collector;

// https://progcont.hu/progcont/100364/?locale=hu&pid=10063
// TLE https://progcont.hu/submission/?id=5e4d797f-2daf-4d1b-b468-d08a3ec70161
public class PermutationGeneratorNaive {

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
                permsOf(word);
            }
        } catch (Exception e) {

        }
    }

    static void permsOf(String word) {
        Deque<Integer> ints = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ints.push(i);
        }
        var res = permsOf(ints, new ArrayList<>());
        res.stream()
                .map(indices -> indices.stream()
                        .map(word::charAt)
                        .collect(Collector.of(StringBuilder::new,
                                StringBuilder::append,
                                StringBuilder::append,
                                StringBuilder::toString)))
        .forEach(System.out::println);
    }

    static List<List<Integer>> permsOf(Deque<Integer> stack, List<List<Integer>> existing) {
        System.out.println("permsOf : ");
        if (stack.size() == 1) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(stack.pop());
            res.add(l);
            return res;
        }
        Integer current = stack.pop();
        var subres = permsOf(stack, existing);
        List<List<Integer>> result = new ArrayList<>();
        for (var exist : subres) {
            result.addAll(inserts(current, exist));
        }
        return result;
    }

    static List<List<Integer>> inserts(Integer insert, List<Integer> existing) {
        System.out.println("insert : " + insert + " " + existing);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= existing.size(); i++) {
            existing.add(i, insert);
            result.add(new ArrayList<>(existing));
            existing.remove(i);
        }
        return result;
    }
}
