package dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NBonacciTest {

    @ParameterizedTest
    @MethodSource("provide_2bonacci")
    void test_2bonacci(int[] basecases, int n, int expected) {
        int actual = NBonacci.nBonacciNoSum(basecases, n);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provide_tribonacci")
    void test_tribonacci(int[] basecases, int n, int expected) {
        int actual = NBonacci.nBonacciNoSum(basecases, n);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provide_2bonacci() {
        return Stream.of(
                Arguments.of(new int[] {0,1}, 0, 0),
                Arguments.of(new int[] {0,1}, 1, 1),
                Arguments.of(new int[] {0,1}, 2, 1),
                Arguments.of(new int[] {0,1}, 3, 2),
                Arguments.of(new int[] {0,1}, 4, 3),
                Arguments.of(new int[] {0,1}, 5, 5),
                Arguments.of(new int[] {0,1}, 6, 8),
                Arguments.of(new int[] {0,1}, 7, 13),
                Arguments.of(new int[] {0,1}, 8, 21),
                Arguments.of(new int[] {0,1}, 9, 34)
        );
    }

    static Stream<Arguments> provide_tribonacci() {
        return Stream.of(
                Arguments.of(new int[] {3,1,3}, 0, 3),
                Arguments.of(new int[] {3,1,3}, 1, 1),
                Arguments.of(new int[] {3,1,3}, 2, 3),
                Arguments.of(new int[] {3,1,3}, 3, 7),
                Arguments.of(new int[] {3,1,3}, 4, 11),
                Arguments.of(new int[] {3,1,3}, 5, 21),
                Arguments.of(new int[] {3,1,3}, 6, 39),
                Arguments.of(new int[] {3,1,3}, 7, 71),
                Arguments.of(new int[] {3,1,3}, 8, 131),
                Arguments.of(new int[] {3,1,3}, 9, 241),
                Arguments.of(new int[] {3,1,3}, 10, 443),
                Arguments.of(new int[] {3,1,3}, 11, 815)
        );
    }
}