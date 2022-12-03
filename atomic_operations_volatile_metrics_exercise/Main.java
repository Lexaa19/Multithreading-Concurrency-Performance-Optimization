package thread.atomic_operations_volatile_metrics_exercise;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String []args){
        MinMaxMetrics mmm = new MinMaxMetrics();
        mmm.addSample(100);

        System.out.println("Minimum "+ mmm.getMin());
        System.out.println("Maximum " + mmm.getMax());
        System.out.println("GetClass " + mmm.getClass());;
    }
}
