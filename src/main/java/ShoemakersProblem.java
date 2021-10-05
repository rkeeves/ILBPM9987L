import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class ShoemakersProblem {

    static class Job {
        final int index;
        final double dx;

        public Job(int index, double dx) {
            this.index = index;
            this.dx = dx;
        }
    }

    public static void main(String[] args) {
        try (final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int caseCount = Integer.parseInt(br.readLine());
            String[] tokens;
            List<Job> jobs = new ArrayList<>(1000);
            boolean first = true;
            for (int caseIndex = 0; caseIndex < caseCount; caseIndex++) {
                if (first) {
                    first = false;
                } else {
                    bw.newLine();
                }
                br.readLine();
                int jobCount = Integer.parseInt(br.readLine());
                jobs.clear();
                for (int jobIndex = 1; jobIndex <= jobCount; jobIndex++) {
                    tokens = br.readLine().split("\\s+");
                    jobs.add(new Job(jobIndex, Integer.parseInt(tokens[0]) / (double)Integer.parseInt(tokens[1])));
                }
                jobs.sort(Comparator.<Job>comparingDouble(a -> a.dx).thenComparingInt(a -> a.index));
                bw.write(jobs.stream()
                        .map(job -> job.index)
                        .map(x -> Integer.toString(x))
                        .collect(Collectors.joining(" ")));
                bw.newLine();
            }
        } catch (Exception e) {

        }
    }
}
