import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnailBruteForceTest {

    @ParameterizedTest(name = "[{index}] : (H={0},U={1},D={2},F={3}) => {4}")
    @CsvFileSource(numLinesToSkip = 2, resources = {"snail.csv", "snailFailure.csv", "snailSuccess.csv", "snailPack.csv"})
    void test_solveByBruteForce(int h,
                               int u,
                               int d,
                               int f,
                               int expected) {
        int actual = SnailBruteForce.solveByBruteForce(h, u, d, f);
        assertEquals(expected, actual);
    }
}