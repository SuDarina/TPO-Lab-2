package function;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EquationSystem es = new EquationSystem(0.001);
        es.collectLogStatistics = true;
        es.collectTrigStatistics = true;
        System.out.println(es.compute(3));
        System.out.println(es.compute(-Math.PI / 6));

    }
}
