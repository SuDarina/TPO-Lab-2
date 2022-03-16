package logarithm;

import function.Function;

public class Ln implements Function {

    private final double eps;

    public Ln(double eps) {
        this.eps = eps;
    }

    public double getEps() {
        return eps;
    }

    private double lnTailor(double x, int n){
        x -= 1;
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result += (Math.pow(x, i) / i) * Math.pow(-1, i + 1);
        }
        return result;
    }

        @Override
        public double compute(double x) {
            double previous = 0;
            double current = Integer.MAX_VALUE;
            int n = 0;

            if (x > 2) return compute(x / 2) + compute(2);

            while (Math.abs(current - previous) > this.getEps()) {
                previous = current;
                current = lnTailor(x, ++n);
            }
            return current;
        }

        public double log(double base, double x) {
            return compute(x) / compute(base);
        }
}
