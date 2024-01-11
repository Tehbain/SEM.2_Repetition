package søgning;

import java.util.List;

public class BinærSøgning {

    public static void main(String[] args) {

    }

    static boolean findNumBinary(List<Integer> numbers, int target) {
        boolean numFound = false;
        int left = 0;
        int right = numbers.size()-1;
        while (!numFound && left <= right) {
            int middle = (left + right) / 2;
            int currentNum = numbers.get(middle);
            if (currentNum == target)
                numFound = true;
            else {
                if (currentNum < target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return numFound;
    }

}
