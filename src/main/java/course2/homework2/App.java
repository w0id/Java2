package course2.homework2;

public class App {
    public static void main(String[] args) {
        Integer[][] array = new Integer[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,Integer.parseInt("11"),12},
                {13,14,15,16,17}
        };
        new CheckArray(array).Check();
    }
}
