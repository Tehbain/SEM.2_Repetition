package sortering;

import java.util.List;

public class SelectionSort {


   public static <T extends Comparable<T>> void selectionSort(List<T> list) {

        for (int i = 0; i < list.size()-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < list.size()-1; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            T temp = list.get(minIndex);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

   public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            // Find det mindste element i det usorterede array
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Byt det mindste element med det første element i det usorterede array
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
