package Beispiel3u4;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Bsp 3
        final Predicate<Integer> isEvenn = i -> i % 2 == 0;
        final IntPredicate isEven = i -> i % 2 == 0;
        final IntPredicate isPositive = i -> i > 0;

        final Predicate<String> isShortWord = s -> s.length() < 4;


        isPositive.and(isEven);
        isEven.negate().and(isPositive);

        //Bsp 4
        final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(isEven.negate()).reduce((i, j) -> i + j * j).orElse(0);
        System.out.println(result);
    }
}
