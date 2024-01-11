package sortering;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println("--------------------------------");
        System.out.println("Før sortéring");
        ArrayList<Integer> list = new ArrayList<>(List.of(2, 8, 4, 7, 43, 3, 75, 24, 96, 36, 3, 74));
        System.out.println(list);
        System.out.println();
        System.out.println("Efter sortéring");
        mergeSort(list);
        System.out.println(list);
    }

    public static void mergeSort(ArrayList<Integer> list) {
        mergeSort(list, 0, list.size() - 1);
    }

    private static void mergeSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(list, low, middle);
            mergeSort(list, middle + 1, high);
            merge(list, low, middle, high);
        }
    }

    private static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int i1 = low;
        int i2 = middle + 1;

        while (i1 <= middle && i2 <= high) {    //Fletning (Total)
            if (list.get(i1) < list.get(i2)) {
                temp.add(list.get(i1));
                i1++;
            } else {
                temp.add(list.get(i2));
                i2++;
            }
        }
        while (i1 <= middle) {                  //Tømning 1
            temp.add(list.get(i1));
            i1++;
        }
        while (i2 <= high) {                    //Tømning 2
            temp.add(list.get(i2));
            i2++;
        }

        for (int i = 0; i < temp.size(); i++) { //Lastning fra temp til list
            int yeet = temp.get(i);
            list.set(low + i, yeet);
        }
    }
}
