package lisp;

import org.junit.jupiter.api.Test;

import static lisp.Lispair.firstOf;
import static lisp.Lispair.secondOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LispairTest {

    @Test
    void demonstrativeUseCase() {
        var pair = Lispair.make(3, "A");
        assertEquals(3, firstOf(pair));
        assertEquals("A", secondOf(pair));
    }
}