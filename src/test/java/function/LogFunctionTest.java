package function;

import logarithm.Ln;
import logarithm.Log;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogFunctionTest {
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {-100, Double.NaN}, {-1, Double.NaN}, {0, Double.NaN},
                {0.1, 1.308}, {0.13107, 1.388}, {0.2, 1.233}, {0.5, 0.374},
                {0.7, 0.113}, {1, Double.NaN}, {3, 1.656}, {5, 3.991},
                {7, 6.256}, {10, 9.385}, {100, 53.715}
        });
    }

    @ParameterizedTest(name = "{index}: log_fun({0}) = {1}")
    @MethodSource("data")
    public void testLogFun(double in, double out) throws IOException {
        double expected, actual;
        Ln ln = new Ln(0.01, false);
        Log log_2 = new Log(ln, 2);
        Log log_3 = new Log(ln, 3);
        Log log_5 = new Log(ln, 5);
        Log log_10 = new Log(ln, 10);
        LogFunction lf = new LogFunction(ln, log_2, log_3, log_5, log_10);
        expected = out;
        actual = lf.compute(in);
        System.out.println("x = " + in + " actual = " + actual
                + " expected = " + expected);
        assertEquals(expected, actual, ln.getEps());
    }
}
