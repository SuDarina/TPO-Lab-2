package trigonometric;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest {

        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                    {0d, 0d}, {Math.PI / 6, 0.5}, {Math.PI / 4, Math.sqrt(2) / 2},
                    {Math.PI / 3, Math.sqrt(3) / 2}, {2*Math.PI / 3, Math.sqrt(3) / 2},
                    {3* Math.PI / 4, Math.sqrt(2) / 2}, {5*Math.PI / 6, 0.5}, {-Math.PI / 6, -0.5},
                    {-Math.PI / 4, -Math.sqrt(2) / 2}, {-Math.PI / 3, -Math.sqrt(3) / 2},
                    {-2*Math.PI / 3, -Math.sqrt(3) / 2}, {-3* Math.PI / 4, -Math.sqrt(2) / 2},
                    {-5*Math.PI / 6, -0.5}, {-Math.PI, 0d}, {Math.PI, 0d}, {Math.PI / 2, 1d},
                    {-Math.PI / 2, -1d}, {-6 * Math.PI, 0d}
            });
        }

        @ParameterizedTest(name = "{index}: sin({0}) = {1}")
        @MethodSource("data")
        public void testSin(double in, double out) throws IOException {
            double expected, actual;
            Sin s = new Sin(0.01, false);
            expected = out;
            actual = s.compute(in);
            System.out.println("x = " + in + " actual = " + actual
                    + " expected = " + expected);
            assertEquals(expected, actual, s.getFault());

        }
}
