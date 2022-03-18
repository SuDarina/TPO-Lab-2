package logarithm;

import function.Function;

import java.io.IOException;

public class Log implements Function {

    private Ln ln;
    private double base;

    public Ln getLn() {
        return ln;
    }

    public void setLn(Ln ln) {
        this.ln = ln;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public Log(Ln ln, double base) {
        this.ln = ln;
        this.base = base;
    }

    @Override
    public double compute(double x) throws IOException {
        return ln.compute(x) / ln.compute(base);
    }
}
