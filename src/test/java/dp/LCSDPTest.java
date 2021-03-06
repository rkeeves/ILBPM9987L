package dp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LCSDPTest {

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/dp/lcs.csv")
    void test(String a, String b, int expected) {
        int actual = LCSDP.lcs(a,b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/dp/lcsLong.csv")
    void testLong(String a, String b, int expected) {
        int actual = LCSDP.lcs(a,b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "/dp/lcsHard.csv")
    void testHard(String a, String b, int expected) {
        int actual = LCSDP.lcs(a,b);
        assertEquals(expected, actual);
    }

    @Test
    void f() {
        String a = "rzadrtdhtuevxhwrcwbaoqdzgdwbrupkurnlkqvdnzamg";
        String b = "dktgljzqkftgjmdywxpkkbcfgphgdneiyzpliqdsxwbgkeggbxsnavtimaqspvapupcdhhxffynpcuyfrq";
        int exp = 16;
        int g = LCSDP.lcs("dbcax","abacd");
        System.out.println(g);
    }
}