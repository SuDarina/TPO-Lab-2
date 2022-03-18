package function;

import logarithm.Ln;
import logarithm.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LogFunIntegrationTest {
    private static final double eps = 0.01;
    private static final Ln ln = Mockito.mock(Ln.class);
    private static final Log log_2 = Mockito.mock(Log.class);
    private static final Log log_3 = Mockito.mock(Log.class);
    private static final Log log_5 = Mockito.mock(Log.class);
    private static final Log log_10 = Mockito.mock(Log.class);
    ;

    public static Collection<Object[]> dataLogFun() {
        return Arrays.asList(new Object[][] {
                {-100, Double.NaN}, {-1, Double.NaN}, {0, Double.NaN},
                {0.1, 1.308}, {0.13107, 1.388}, {0.2, 1.233}, {0.5, 0.374},
                {0.7, 0.113}, {1, Double.NaN}, {3, 1.656}, {5, 3.991},
                {7, 6.256}, {10, 9.385}, {100, 53.696}
        });
    }

    @BeforeAll
    public static void setup() throws IOException {

        log_2.setBase(2);
        log_3.setBase(3);
        log_5.setBase(5);
        log_10.setBase(10);

        when(ln.compute(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]));
        when(log_2.compute(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]) / Math.log(2));
        when(log_3.compute(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]) / Math.log(3));
        when(log_5.compute(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]) / Math.log(5));
        when(log_10.compute(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]) / Math.log(10));


    }

    @ParameterizedTest(name = "{index}: logFun({0}) = {1}")
    @MethodSource("dataLogFun")
    public void testLog(double in, double out) throws IOException {
        LogFunction lf = new LogFunction(ln, log_2, log_3, log_5, log_10);
        double expected, actual;
        expected = out;
        actual = lf.compute(in);
        System.out.println("x = " + in + " actual = " + actual
                + " expected = " + expected);
        assertEquals(expected, actual, eps);
    }
}
