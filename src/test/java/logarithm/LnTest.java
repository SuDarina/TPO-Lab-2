package logarithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LnTest {

    public static Collection<Object[]> dataLn() {
        return Arrays.asList(new Object[][] {
                {-1, Double.NaN}, {0, Double.NaN}, {1, 0},
                {Math.E, 1}, {Math.pow(Math.E, 2), 2},
                {Math.pow(Math.E, 3), 3}, {Math.pow(Math.E, 10), 10},
                {5, 1.609}, {2, 0.69}
        });
    }

    public static Collection<Object[]> dataLog() {
        return Arrays.asList(new Object[][] {
                {0, -1, Double.NaN}, {-1, 0, Double.NaN}, {0, 0, Double.NaN},
                {2, 2, 1}, {2, 1, 0}, {3, 1, 0}, {100, 1, 0},
                {3, 27, 3}, {3, 9, 2}, {4, 16, 2},
                {Math.E, Math.pow(Math.E, 2), 2}, {10, 1000, 3}
        });
    }


    @ParameterizedTest(name = "{index}: ln({0}) = {1}")
    @MethodSource("dataLn")
    public void testLn(double in, double out) throws IOException {
        double expected, actual;
        Ln l = new Ln(0.01, false);
        expected = out;
        actual = l.compute(in);
        System.out.println("x = " + in + " actual = " + actual
                + " expected = " + expected);
        System.out.println(l.getEps());
        assertEquals(expected, actual, l.getEps());

    }

    @ParameterizedTest(name = "{index}: ln({0}) = {1}")
    @MethodSource("dataLog")
    public void testLog(double base, double in, double out) throws IOException {
        double expected, actual;
        Ln l = new Ln(0.01, false);
        expected = out;
        actual = l.log(base, in);
        System.out.println("base: " + base + "x = " + in + " actual = " + actual
                + " expected = " + expected);
        System.out.println(l.getEps());
        assertEquals(expected, actual, l.getEps());

    }
}
