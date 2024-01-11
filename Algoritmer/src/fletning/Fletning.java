package fletning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fletning {
    public static void main(String[] args) {

        int[] intArr1 = new int[]{312,346,5,12,344,5,23,5,6,34,34,352,124,2,76};
        Arrays.sort(intArr1);
        int[] intArr2 = new int[]{153,45,1,8,45,2,7,9,1337,69,420};
        Arrays.sort(intArr2);

        System.out.println("2 serier af heltal");
        System.out.println(Arrays.toString(intArr1));
        System.out.println(Arrays.toString(intArr2));
        System.out.println();

        System.out.println("Totalfletning af en serie af heltal");
        int[] intArrResult = merge(intArr1, intArr2);
        int[] intArrCompare = Arrays.copyOf(intArrResult, intArrResult.length);
        Arrays.sort(intArrCompare);
        System.out.println(Arrays.toString(intArrResult));
        System.out.println(Arrays.toString(intArrCompare));
        System.out.println("er ovenstående sorteret?: " + Arrays.equals(intArrResult, intArrCompare));

    }


    static int[] merge(int[] s1, int[] s2) {
        int[] result = new int[s1.length + s2.length];

        int i1 = 0, i2 = 0, j = 0;

        //Fletning af serier af heltal
        while (i1 < s1.length && i2 < s2.length) {
            if (s1[i1] < s2[i2]) {
                // e1 er mindst
                result[j] = s1[i1];
                i1++;
                j++;
            } else {
                // e2 er mindre eller lig med e1
                result[j] = s2[i2];
                i2++;
                j++;
            }
        }

        //Tømning
        while (i1 < s1.length) {
            result[j] = s1[i1];
            i1++;
            j++;
        }
        while (i2 < s2.length) {
            result[j] = s2[i2];
            i2++;
            j++;
        }
        return result;
    }

    //Total fletning med Comparable type.
    static <T extends Comparable<T>> List<T> merge(List<T> s1, List<T> s2) {
        List<T> result = new ArrayList<>();

        int i1 = 0, i2 = 0;

        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1).compareTo(s2.get(i2)) < 0) {
                // e1 er mindst
                result.add(s1.get(i1));
                i1++;
            } else {
                // e2 er mindst eller lige stort
                result.add(s2.get(i2));
                i2++;
            }
        }

        // Tilføj resten af elementerne fra s1 og s2
        while (i1 < s1.size()) {
            result.add(s1.get(i1));
            i1++;
        }

        while (i2 < s2.size()) {
            result.add(s2.get(i2));
            i2++;
        }
        return result;
    }

    // Generel fletning, med regler for at flette fællesmængden
    public ArrayList<Integer> intersection(
            ArrayList<Integer> s1, ArrayList<Integer> s2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1) < s2.get(i2)) {
                i1++;
            } else if (s1.get(i1) > s2.get(i2)) {
                i2++;
            } else {
                result.add(s1.get(i1));
                i1++;
                i2++;
            }
        }
        return result;
    }
}
