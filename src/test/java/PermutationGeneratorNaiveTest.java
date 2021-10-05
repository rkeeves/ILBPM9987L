import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationGeneratorNaiveTest {

    @Test
    void test_tiny() {
        System.out.println("> abcde");
        PermutationGeneratorNaive.permsOf("abcde");
    }

    @Test
    void test_small() {
        System.out.println("> a");
        PermutationGeneratorNaive.permsOf("a");
        System.out.println("> ab");
        PermutationGeneratorNaive.permsOf("ab");
        System.out.println("> abc");
        PermutationGeneratorNaive.permsOf("abc");
        System.out.println("> abcd");
        PermutationGeneratorNaive.permsOf("abcd");
    }

    @Test
    void test_large() {
        PermutationGeneratorNaive.permsOf("abcdefghi");
    }
}