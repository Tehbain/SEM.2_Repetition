package sortering;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] iArr) {

        for (int i = 1; i < iArr.length; ++i) {
            int k = iArr[i];
            int j = i - 1;

            // Flyt elementer af array[0..i-1], der er større end key,
            // til en position foran deres nuværende position
            while (j >= 0 && iArr[j] > k) {
                iArr[j + 1] = iArr[j];
                j--;
            }
            iArr[j + 1] = k;
        }
    }

    public static void main(String[] args) {
        // Opret et array med 8 tilfældige tal mellem 1 og 99
        int[] iArr = {47, 12, 64, 33, 88, 17, 96, 52};

        System.out.println();

        System.out.println("Usorteret array: " + Arrays.toString(iArr));

        System.out.println();
        insertionSort(iArr);

        System.out.println("Sorteret array: " + Arrays.toString(iArr));
    }
}