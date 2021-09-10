package lisp;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Lispair<A, B> {

    <R> R apply(BiFunction<A, B, R> f);

    static <A, B> Lispair<A, B> make(A first, B second) {
        return new Lispair<>() {
            @Override
            public <R> R apply(BiFunction<A, B, R> f) {
                return f.apply(first,second);
            }
        };
    }

    static <A, B> A firstOf(Lispair<A, B> lispair) {
        return lispair.apply((first,second)->first);
    }

    static <A, B> B secondOf(Lispair<A, B> lispair) {
        return lispair.apply((first,second)->second);
    }
}
