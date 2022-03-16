package trigonometric;

import function.Function;

public class Sin implements Function {

    private final double eps;

    public Sin(double eps) {
        this.eps = eps;
    }

    public double getFault() {
        return eps;
    }

    private double sinTailor(double x, int n){
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result += Math.pow(-1, i - 1) * (Math.pow(x, 2 * i - 1) / getFactorial(2 * i - 1));
        }
        return result;
    }

    public long getFactorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * getFactorial(n - 1);
    }

    @Override
    public double compute(double x) {
        double previous = 0;
        double current = 2;
        int n = 0;

        x = Math.abs(x) >= Math.PI * 2 ? (x - (Math.PI * 2 * (int) (x / (Math.PI * 2)))) : x;

        while(Math.abs(current - previous) > this.getFault()){
            previous = current;
            current = sinTailor(x, ++n);
        }
        return current;
    }
}
