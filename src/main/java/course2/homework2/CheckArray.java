package course2.homework2;

public class CheckArray {

    private static Integer sum = 0;

    public static Integer GetSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4 || array.length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, e);
                }
            }
        }
        return sum;
    }
}
