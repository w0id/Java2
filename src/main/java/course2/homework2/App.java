package course2.homework2;

public class App {
    public static void main(String[] args) {
        String[][] array = new String[][] {
                {"1", "2", "3", "4"},
                {"5","6","7","8"},
//                {"5","6","s","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
//                {"13","14","15","16", "17"}
        };
        try {
            System.out.println(CheckArray.GetSum(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
