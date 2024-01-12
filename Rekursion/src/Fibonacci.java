public class Fibonacci {
    public static void main(String[] args) {

        int n = 4;
        int result = fibonacci(n);
        System.out.println();
        System.out.println("F(" + n + ") = " + result);
    }
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Stopbetingelse: F(0) = 0, F(1) = 1
        } else {
            // Rekursivt kald: F(n) = F(n-1) + F(n-2)
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            System.out.print(result + ", ");
            return result;
        }
    }
}
