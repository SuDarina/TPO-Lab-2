package logarithm;

import function.Function;
import system.CsvWork;

import java.io.IOException;

public class Ln implements Function {

    private final double eps;
    private boolean collectStatistics;

    public Ln(double eps, boolean collectStatistics) {
        this.eps = eps;
        this.collectStatistics = collectStatistics;
    }

    public double getEps() {
        return eps;
    }

    public boolean isCollectStatistics() {
        return collectStatistics;
    }

    public void setCollectStatistics(boolean collectStatistics) {
        this.collectStatistics = collectStatistics;
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
        public double compute(double x) throws IOException {
            double previous = 0;
            double current = Integer.MAX_VALUE;
            int n = 0;

            if (x > 2) {
                if(collectStatistics) {
                    CsvWork.writeToCSV("Ln", x, current);
                }
                return compute(x / 2) + compute(2);
            }

            while (Math.abs(current - previous) > this.getEps()) {
                previous = current;
                current = lnTailor(x, ++n);
            }

            if(collectStatistics) {
                CsvWork.writeToCSV("Ln", x, current);
            }
            return current;
        }

        public double log(double base, double x) throws IOException {
            return compute(x) / compute(base);
        }
}
