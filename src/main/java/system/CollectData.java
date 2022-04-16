package system;

import logarithm.Ln;
import trigonometric.Sin;

import java.io.IOException;

public class CollectData {

    private double step;
    private double start;
    private double finish;

    public CollectData(double step, double start, double finish) {
        this.step = step;
        this.start = start;
        this.finish = finish;
    }

    private final double eps = 0.01;

    Ln ln = new Ln(eps, true);
    Sin sin = new Sin(eps, true);

    public void collectData() throws IOException {
        for (double i = start; i < finish; i += step){
            ln.compute(i);
            sin.compute(i);
        }
    }

}
