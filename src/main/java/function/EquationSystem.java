package function;

import logarithm.Ln;
import trigonometric.Sin;

public class EquationSystem implements Function{

    private double eps;

    public EquationSystem(double eps) {
        this.eps = eps;
    }

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    private double logFun(double x){
        Ln ln = new Ln(eps);
        return ((((ln.log(2, x) - ln.log(3, x))
                * ln.log(5, x)) + (ln.log(2, x -
                ln.log(10, x)))) / ln.compute(x)) *
                (ln.compute(x) * ln.compute(x));
    }

    @Override
    public double compute(double x) {
        if(x <= 0){
            Sin sin = new Sin(eps);
            return sin.compute(x);
        } else {
            return logFun(x);
        }
    }
}
