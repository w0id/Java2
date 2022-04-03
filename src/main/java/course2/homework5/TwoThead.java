package course2.homework5;

import java.util.stream.IntStream;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class TwoThead {

    private final int HALF;
    private final float[] arr;
    private final float[] a1;
    private final float[] a2;

    public TwoThead(float[] arr) {
        this.arr = arr;
        this.HALF = arr.length / 2;
        this.a1 = new float[HALF];
        this.a2 = new float[HALF];
    }

    public void twoThreadedCalc() {
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr,0, a1,0, HALF);
        System.arraycopy(arr, HALF, a2,0, HALF);
        Thread t1 = new Thread(() -> calc(a1));
        Thread t2 = new Thread(() -> calc(a2));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1,0, arr,0, HALF);
        System.arraycopy(a2,0, arr, HALF, HALF);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public void calc(float[] inputArray) {
        IntStream.range(0, inputArray.length)
                .forEach(i -> inputArray[i] = (float) (inputArray[i] * sin(0.2f + i / 5) * cos(0.2f + i / 5) * cos(0.4f + i / 2)));
    }

}
