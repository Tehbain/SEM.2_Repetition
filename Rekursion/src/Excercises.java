public class Excercises {
    public static void main(String[] args) {

    }

    public static int factorial (int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static int power(int n, int p) {
        if (p == 1) return 1;
        else return power(n,p-1) * n;
    }

    public static String reverse(String s) {
        return null;
    }
}
