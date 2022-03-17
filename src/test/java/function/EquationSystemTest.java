package function;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquationSystemTest {
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0}, {-Math.PI / 4, -Math.sqrt(2) / 2},
                {-Math.PI / 3, -Math.sqrt(3) / 2}, {-2*Math.PI / 3, -Math.sqrt(3) / 2},
                {-3* Math.PI / 4, -Math.sqrt(2) / 2}, {-5*Math.PI / 6, -0.5},
                {-Math.PI, 0d}, {-Math.PI / 2, -1d}, {-6 * Math.PI, 0d},
                {0.1, 1.308}, {0.13107, 1.388}, {0.2, 1.233}, {0.5, 0.374},
                {0.7, 0.113}, {1, Double.NaN}, {3, 1.656}, {5, 3.991},
                {7, 6.256}, {10, 9.385}, {100, 53.715}
        });
    }

    @ParameterizedTest(name = "{index}: fun({0}) = {1}")
    @MethodSource("data")
    public void testSin(double in, double out) throws IOException {
        double expected, actual;
        EquationSystem es = new EquationSystem(0.01);
        es.collectLogStatistics = true;
        es.collectTrigStatistics = true;
        expected = out;
        actual = es.compute(in);
        System.out.println("x = " + in + " actual = " + actual
                + " expected = " + expected);
        assertEquals(expected, actual, es.getEps());

    }
}
