package dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubarray1DOptTest {

    @ParameterizedTest
    @MethodSource("provide")
    void test(int[] arr, int expected) {
        var actual = MaxSubarray1DOpt.maxSubarray(arr);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{5,4,-1,7,8}, 23)
        );
    }
}