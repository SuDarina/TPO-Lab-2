package function;

import logarithm.Ln;
import logarithm.Log;

import java.io.IOException;

public class LogFunction implements Function {
    private  Ln ln;
    private Log log_2;
    private Log log_3;
    private Log log_5;
    private Log log_10;

    public LogFunction(Ln ln) {
        this.ln = ln;
    }

    public LogFunction(Ln ln, Log log_2, Log log_3, Log log_5, Log log_10) {
        this.ln = ln;
        this.log_2 = log_2;
        this.log_3 = log_3;
        this.log_5 = log_5;
        this.log_10 = log_10;
    }

    @Override
    public double compute(double x) throws IOException {
        if(x > 0 & x < 1 || x > 1)
            return (((((log_2.compute(x) - log_3.compute(x)) * log_5.compute(x)) +
                    (log_2.compute(x) - log_10.compute(x))) / ln.compute(x)) *
                    (ln.compute(x) * ln.compute(x)));
        else return Double.NaN;
    }
}

