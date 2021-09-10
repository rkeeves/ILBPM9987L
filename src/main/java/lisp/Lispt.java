package lisp;

import java.util.function.BiFunction;

public interface Lispt<T> {

    <R> R apply(BiFunction<T, Lispt<T>, R> f);

    static Lispt EMPTY_LIST = new Lispt<>() {

        @Override
        public <R> R apply(BiFunction<Object, Lispt<Object>, R> f) {
            throw new RuntimeException("Empty list cannot be accessed");
        }
    };

    static <T> Lispt<T> emptyList() {
        return (Lispt<T>)EMPTY_LIST;
    };

    static <T> Lispt<T> cons(T head, Lispt<T> tail) {
        return new Lispt<>() {

            @Override
            public <R> R apply(BiFunction<T, Lispt<T>, R> f) {
                return f.apply(head, tail);
            }
        };
    }

    static <T> T car(Lispt<T> lispt) {
        return lispt.apply((head, tail) -> head);
    }

    static <T> Lispt<T> cdr(Lispt<T> lispt) {
        return lispt.apply((head, tail) -> tail);
    }

    static <T> boolean isEmpty(Lispt<T> lispt) {
        return lispt == Lispt.emptyList();
    }
}
