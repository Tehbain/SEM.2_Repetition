public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Fittif " + isPalindrome("Fittif"));
        System.out.println("Lømmel " + isPalindrome("Lømmel"));
        System.out.println("Saaas " + isPalindrome("Saaas"));
    }

    public static boolean isPalindrome(String string) {
        String s = string.toLowerCase();

        if (s.length() <= 1) {
            return true;
        }

        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        return isPalindrome(s.substring(1, s.length() - 1));
    }
}
