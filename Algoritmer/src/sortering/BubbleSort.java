package sortering;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        System.out.println();

        int[] intArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Usorteret array: " + Arrays.toString(intArray));
        bubbleSort(intArray);
        System.out.println("Sorteret array: " + Arrays.toString(intArray));

        System.out.println();

        String[] strArray = {"banana", "apple", "orange", "grape", "kiwi"};
        System.out.println("Usorteret array: " + Arrays.toString(strArray));
        bubbleSort(strArray);
        System.out.println("Sorteret array: " + Arrays.toString(strArray));
    }
    public static void bubbleSort(int[] iArr) {
        for (int i = 0; i < iArr.length - 1; i++) {
            for (int j = 0; j < iArr.length - i - 1; j++) {
                if (iArr[j] > iArr[j + 1]) {
                    // Swap med sidemanden.
                    int temp = iArr[j];
                    iArr[j] = iArr[j + 1];
                    iArr[j + 1] = temp;
                }
            }
        }
    }


    public static <T extends Comparable<T>> void bubbleSort(T[] tArr) {
        for (int i = 0; i < tArr.length - 1; i++) {
            for (int j = 0; j < (tArr.length - i - 1); j++) {
                if (tArr[j].compareTo(tArr[j + 1]) > 0) {
                    T temp = tArr[j];
                    tArr[j] = tArr[j + 1];
                    tArr[j + 1] = temp;
                }
            }
        }
    }
}