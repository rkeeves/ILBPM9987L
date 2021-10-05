import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class NessieTest {
/*
    @ParameterizedTest
    @MethodSource("provider")
    void test(int n, int m) {
        assertEquals(Nessie.nessie2(n, m), Nessie.nessie(n, m));

    }*/

    static Stream<Arguments> provider() {
        return IntStream.range(6,100)
                .boxed()
                .flatMap(n -> IntStream.range(6,100)
                        .mapToObj(m -> Arguments.of(n,m)));
    }
/*
    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "nessie.csv")
    void testCsv(int n, int m, int expected) {
        assertEquals(expected, Nessie.nessie(n, m));
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "nessieGen.csv")
    void testGen(int n, int m, int expected) {
        assertEquals(expected, Nessie.nessie(n, m));
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "nessieLong.csv")
    void testLong(int n, int m, int expected) {
        assertEquals(expected, Nessie.nessie(n, m));
    }

    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1, resources = "nessieStrings.csv")
    void testLong(String s, String expected) {
        assertEquals(expected, Nessie.nessie3(s));
    }*/
}