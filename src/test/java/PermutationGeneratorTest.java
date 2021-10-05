import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class PermutationGeneratorTest {

    @Test
    void test() {
        PermutationGenerator.permute("abc");
    }

    public static void main(String[] args) {
        var r = Arrays.stream("dktgljzqkftgjmdywxpkkbcfgphgdneiyzpliqdsxwbgkeggbxsnavtimaqspvapupcdhhxffynpcuyfrq".split("")).collect(Collectors.joining(", "));
        System.out.println(r);
    }
}