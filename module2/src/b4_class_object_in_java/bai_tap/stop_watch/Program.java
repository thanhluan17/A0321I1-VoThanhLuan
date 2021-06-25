package b4_class_object_in_java.bai_tap.stop_watch;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        double[] array = new double[100000];
        for (int j = 0; j < 100000; j++) {
            array[j] = Math.random();
        }
        StopWatch stopWatch = new StopWatch();
        Arrays.sort(array);
        stopWatch.stop();
        long milliseconds = stopWatch.getElapsedTime();
        System.out.println("Time execute: " + milliseconds);
    }
}
