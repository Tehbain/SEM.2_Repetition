public class Binomial {
    public static void main(String[] args) {

    }

    public static int binomial(int n, int m) {
        if (m == 0 || m == n) return 1;
        else return binomial(n-1, m) + binomial(n-1, m-1);
    }
}
