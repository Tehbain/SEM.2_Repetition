package søgning;

import java.util.ArrayList;
import java.util.List;

public class LineærSøgning {

    public static void main(String[] args) {

    }

    static boolean findNumber(List<Integer> numbers, int target) {
        boolean numFound = false;
        int i = 0;

        while (!numFound && i < numbers.size()) {
            if (numbers.get(i) == target) {
                numFound = true;
            } else {
                i++;
            }
        }
        return numFound;
    }

}
