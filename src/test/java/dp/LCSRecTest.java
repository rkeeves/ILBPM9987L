package dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LCSRecTest {

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/dp/lcs.csv")
    void test(String a, String b, int expected) {
        int actual = LCSRec.lcs(a,b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/dp/lcsLong.csv")
    void testLong(String a, String b, int expected) {
        int actual = LCSRec.lcs(a,b);
        assertEquals(expected, actual);
    }
}