package extra.basic;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        for (int i = 1; i < array.length; i++) {
            int tempIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[tempIndex]) {
                    int temp = array[j];
                    array[j] = array[tempIndex];
                    array[tempIndex] = temp;
                    tempIndex--;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
