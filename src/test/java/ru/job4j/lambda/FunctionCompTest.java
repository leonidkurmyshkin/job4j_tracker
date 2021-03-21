package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class FunctionCompTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionComp.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = FunctionComp.diapason(5, 8, x -> x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(36., 49., 64.);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPowerFunction() {
        List<Double> result = FunctionComp.diapason(1, 4, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(5., 25., 125.);
        assertThat(result, is(expected));
    }
}