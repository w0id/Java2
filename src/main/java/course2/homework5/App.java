package course2.homework5;

import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        final int SIZE = 10_000_000;
        float[] arr = new float[SIZE];
        IntStream.range(0, arr.length).forEach(i -> arr[i] = 1.0f);
        new OneThread(arr).oneThreadedCalc();
        IntStream.range(0, arr.length).forEach(i -> arr[i] = 1.0f);
        new TwoThead(arr).twoThreadedCalc();
    }
}
