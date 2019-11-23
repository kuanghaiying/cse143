public class IsPalindromeRecursion {
    public static void main(String[] args) {
        System.out.println(isPalindrome(""));
        String str = "A";
        System.out.println(str.substring(0, 1) + "/");
    }

    public static boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        } else if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        } else if (str.length() == 1 || (str.length() == 2 && str.charAt(0) == str.charAt(1))) {
            return true;
        } else {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
    }
}
