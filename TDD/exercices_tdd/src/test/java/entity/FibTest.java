package entity;

import org.example.entity.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FibTest {
    private Fib fibUnderTest;

    void initFib(int range) {
        fibUnderTest = new Fib(range);
    }

    @Test
    void givenRange1WhenGetFibSeriesThenFibSeriesIsNotEmpty() {
        initFib(1);

        boolean fibSeriesIsEmpty = fibUnderTest.getFibSeries().isEmpty();

        Assertions.assertFalse(fibSeriesIsEmpty);
    }

    @Test
    void givenRange1WhenGetFibSeriesThenFibSeriesIsListWith0() {
        initFib(1);

        List<Integer> fibSeries = fibUnderTest.getFibSeries();

        Assertions.assertEquals(List.of(0), fibSeries);
    }

    @Test
    void givenRange6WhenGetFibSeriesThenFibSeriesContains3() {
        initFib(6);

        List<Integer> fibSeries = fibUnderTest.getFibSeries();

        Assertions.assertTrue(fibSeries.contains(3));
    }

    @Test
    void givenRange6WhenGetFibSeriesThenFibSeriesSizeEquals6() {
        initFib(6);

        List<Integer> fibSeries = fibUnderTest.getFibSeries();

        Assertions.assertEquals(6, fibSeries.size());
    }

    @Test
    void givenRange6WhenGetFibSeriesThenFibSeriesNotContains4() {
        initFib(6);

        List<Integer> fibSeries = fibUnderTest.getFibSeries();

        Assertions.assertFalse(fibSeries.contains(4));
    }

    @Test
    void givenRange6WhenGetFibSeriesThenFibSeriesContainsAllValues() {
        initFib(6);

        List<Integer> fibSeries = fibUnderTest.getFibSeries();

        Assertions.assertTrue(fibSeries.containsAll(Arrays.asList(0, 1, 1, 2, 3, 5)));
    }

    @Test
    void givenRange6WhenGetFibSeriesThenFibSeriesContainsAllValuesSortedAsc() {
        initFib(6);

        List<Integer> fibSeries = fibUnderTest.getFibSeries();
        List<Integer> sortedFibSeries = List.copyOf(fibSeries);
        Arrays.sort(sortedFibSeries.toArray());

        Assertions.assertEquals(sortedFibSeries, fibSeries);
    }
}
