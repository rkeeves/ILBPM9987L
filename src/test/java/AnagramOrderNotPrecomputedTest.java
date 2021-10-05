import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramOrderNotPrecomputedTest {

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "qsort.csv")
    void test(String s, String expected) {
        char[] arr = s.toCharArray();
        AnagramOrderNotPrecomputed.quickSort(arr, 0, arr.length-1);
        assertEquals(expected, new String(arr));
    }

    @ParameterizedTest
    @MethodSource("provideIndexOf")
    void testIndexOf(char c, int expected) {
        assertEquals(expected, AnagramOrderNotPrecomputed.indexOf(c));
    }

    static Stream<Arguments> provideIndexOf() {
        int i = 0;
        ArrayList<Arguments> args = new ArrayList<>();
        for (char c = 'a';c <= 'z'; c++) {

            args.add(Arguments.of(Character.toUpperCase(c), i++));
            args.add(Arguments.of(c, i++));
        }
        return args.stream();
    }

    @ParameterizedTest
    @MethodSource("provideOffsetOf")
    void testOffsetOf(char c, int expected) {
        assertEquals(expected, AnagramOrderNotPrecomputed.offsetOf(c));
    }

    static Stream<Arguments> provideOffsetOf() {
        int i = 0;
        ArrayList<Arguments> args = new ArrayList<>();
        for (char c = 'a';c <= 'z'; c++) {
            args.add(Arguments.of(Character.toUpperCase(c), i));
            args.add(Arguments.of(c, i++));
        }
        return args.stream();
    }
}