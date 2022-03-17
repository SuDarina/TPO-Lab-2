package function;

import logarithm.Ln;

import java.io.IOException;

public class LogFunction {
    private final Ln ln;

    public LogFunction(Ln ln) {
        this.ln = ln;
    }

    public double logFun(double x) throws IOException {
        if(x > 0 & x < 1 || x > 1)
            return (((((ln.log(2, x) - ln.log(3, x)) * ln.log(5, x)) +
                    (ln.log(2, x) - ln.log(10, x))) / ln.compute(x)) *
                    (ln.compute(x) * ln.compute(x)));
        else return Double.NaN;
    }
}

