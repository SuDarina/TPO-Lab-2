package function;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EquationSystem es = new EquationSystem(0.001);
        es.collectLogStatistics = true;
//        es.collectTrigStatistics = true;
        System.out.println(es.compute(0)); // 1.3078723079882582
        System.out.println(es.compute(0.1)); // 1.3878867564800559
        System.out.println(es.compute( 0.13107)); // 1.2326318252590944
        System.out.println(es.compute(0.2)); // 0.37425826467661377
        System.out.println(es.compute(0.5)); // 0.11327487487118551
        System.out.println(es.compute(0.7)); // NaN
        System.out.println(es.compute(1)); // 1.6556380193913363
        System.out.println(es.compute(3)); // 3.9910236580928227
        System.out.println(es.compute(5)); // 6.255648220314913
        System.out.println(es.compute(7)); // 9.384665265911355
        System.out.println(es.compute(10)); // 53.692483440837215
        System.out.println(es.compute(100));

    }
}
