package logarithm;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LogTest {

    private static final double eps = 0.01;
    private static Ln ln;

    public static Collection<Object[]> dataLog() {
        return Arrays.asList(new Object[][] {
                {0, -1, Double.NaN}, {-1, 0, Double.NaN}, {0, 0, Double.NaN},
                {2, 2, 1}, {2, 1, 0}, {3, 1, 0}, {100, 1, 0},
                {3, 27, 3}, {3, 9, 2}, {4, 16, 2},
                {Math.E, Math.pow(Math.E, 2), 2}, {10, 1000, 3}
        });
    }

    @BeforeAll
    public static void setup() throws IOException {

        ln = Mockito.mock(Ln.class);

        when(ln.compute(0)).thenReturn(Double.NaN);
        when(ln.compute(-1)).thenReturn(Double.NaN);
        when(ln.compute(2)).thenReturn(0.69315);
        when(ln.compute(1)).thenReturn(0d);
        when(ln.compute(3)).thenReturn(1.09861);
        when(ln.compute(100)).thenReturn(4.60517);
        when(ln.compute(27)).thenReturn(3.29584);
        when(ln.compute(9)).thenReturn(2.19722);
        when(ln.compute(4)).thenReturn(1.38629);
        when(ln.compute(16)).thenReturn(2.77259);
        when(ln.compute(Math.E)).thenReturn(1d);
        when(ln.compute(Math.pow(Math.E, 2))).thenReturn(2d);
        when(ln.compute(10)).thenReturn(2.30259);
        when(ln.compute(1000)).thenReturn(6.90776);

    }

    @ParameterizedTest(name = "{index}: log_{0}({1}) = {2}")
    @MethodSource("dataLog")
    public void testLog(double base, double in, double out) throws IOException {
        double expected, actual;
        Log log = new Log(ln, base);
        expected = out;
        actual = log.compute(in);
        System.out.println("base: " + base + " x = " + in + " actual = " + actual
                + " expected = " + expected);
        assertEquals(expected, actual, eps);
    }

}
