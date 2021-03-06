package course2.homework5;

import java.util.stream.IntStream;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class OneThread {

    private final float[] arr;

    public OneThread(float[] arr) {
        this.arr = arr;
    }

    public void oneThreadedCalc() {
        long startTime = System.currentTimeMillis();
        int bound = arr.length;
        IntStream.range(0, bound)
                .forEach(i -> arr[i] = (float) (arr[i] * sin(0.2f + i / 5) * cos(0.2f + i / 5) * cos(0.4f + i / 2)));
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

}
