package function;

import logarithm.Ln;
import logarithm.Log;
import trigonometric.Sin;

import java.io.IOException;

public class EquationSystem implements Function{

    private double eps;
    public boolean collectTrigStatistics = false;
    public boolean collectLogStatistics = false;

    public EquationSystem(double eps) {
        this.eps = eps;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    @Override
    public double compute(double x) throws IOException {
        Ln ln = new Ln(eps, collectLogStatistics);
        Log log_2 = new Log(ln, 2);
        Log log_3 = new Log(ln, 3);
        Log log_5 = new Log(ln, 5);
        Log log_10 = new Log(ln, 10);
        if(x <= 0){
            Sin sin = new Sin(eps, collectTrigStatistics);
            return sin.compute(x);
        } else {
            LogFunction lf = new LogFunction(ln, log_2, log_3, log_5, log_10);
            return lf.compute(x);
        }
    }
}
