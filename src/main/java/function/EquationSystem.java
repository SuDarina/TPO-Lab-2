package function;

import logarithm.Ln;
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
        if(x <= 0){
            Sin sin = new Sin(eps, collectTrigStatistics);
            return sin.compute(x);
        } else {
            LogFunction lf = new LogFunction(new Ln(eps, collectLogStatistics));
            return lf.logFun(x);
        }
    }
}
