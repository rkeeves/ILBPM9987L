package lisp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lisp.Lispt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LisptTest {

    @Test
    void demonstrativeUseCase() {
        var lispt = cons(1, cons(2, cons(3, emptyList())));
        var expected = List.of(1,2,3);
        var actual = collect(lispt, new ArrayList<>());
        assertEquals(expected, actual);
    }

    List<Integer> collect(Lispt<Integer> lispt, List<Integer> list) {
        if (isEmpty(lispt)) {
            return list;
        }
        list.add(car(lispt));
        return collect(cdr(lispt), list);
    }
}