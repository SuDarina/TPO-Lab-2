package function;

import logarithm.Ln;
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
    public void testSin(double in, double out) throws IOException {
        double expected, actual;
        Ln ln = new Ln(0.01, false);
        LogFunction lf = new LogFunction(ln);
        expected = out;
        actual = lf.logFun(in);
        System.out.println("x = " + in + " actual = " + actual
                + " expected = " + expected);
        assertEquals(expected, actual, ln.getEps());

    }
}
