package course2.homework2;

public class MyArrayDataException extends Exception{

    public MyArrayDataException(int i, int j, Throwable cause) {
        super("Некорректное значение элемента " + j + " в массиве " + i, cause);
    }
}
