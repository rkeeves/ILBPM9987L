import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistanceDPTwoRowsOnlyTest {

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "editDistance.csv")
    void test(String a, String b, int expected) {
        int actual = EditDistanceDPTwoRowsOnly.editDistance(a, b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "editDistance2.csv")
    void testHeavy(String a, String b, int expected) {
        int actual = EditDistanceDPTwoRowsOnly.editDistance(a, b);
        assertEquals(expected, actual);
    }
}