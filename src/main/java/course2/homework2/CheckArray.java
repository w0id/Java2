package course2.homework2;

public class CheckArray {

    private Integer[][] array;

    public CheckArray(Integer[][] array) {
        this.array = array;
    }

    void Check() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int cell = array[i][j];
                System.out.println(cell);
            }
        }
    }
}
