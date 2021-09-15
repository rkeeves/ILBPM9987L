import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnailConstOTest {

    @ParameterizedTest(name = "[{index}] : (H={0},U={1},D={2},F={3}) => {4}")
    @CsvFileSource(numLinesToSkip = 2, resources = "snailSuccess.csv")
    void test_solveByConst_Success(int h,
                           int u,
                           int d,
                           int f,
                           int expected) {
        int actual = SnailConstO.solveByConst(h, u, d, f);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "[{index}] : (H={0},U={1},D={2},F={3}) => {4}")
    @CsvFileSource(numLinesToSkip = 2, resources = "snailFailure.csv")
    void test_solveByConst_Failure(int h,
                                   int u,
                                   int d,
                                   int f,
                                   int expected) {
        int actual = SnailConstO.solveByConst(h, u, d, f);
        assertEquals(expected, actual);
    }
}