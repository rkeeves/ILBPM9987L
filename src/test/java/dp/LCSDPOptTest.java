package dp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LCSDPOptTest {

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/dp/lcs.csv")
    void test(String a, String b, int expected) {
        int actual = LCSDPOpt.lcs(a,b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/dp/lcsLong.csv")
    void testLong(String a, String b, int expected) {
        int actual = LCSDPOpt.lcs(a,b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/dp/lcsHard.csv")
    void testHard(String a, String b, int expected) {
        int actual = LCSDPOpt.lcs(a,b);
        assertEquals(expected, actual);
    }

    @Test
    void f() {
        String a = "rzadrtdhtuevxhwrcwbaoqdzgdwbrupkurnlkqvdnzamg";
        String b = "dktgljzqkftgjmdywxpkkbcfgphgdneiyzpliqdsxwbgkeggbxsnavtimaqspvapupcdhhxffynpcuyfrq";
        int exp = 16;
        int act = LCSDPOpt.lcs4(a,b);
        System.out.println(act);
    }
}