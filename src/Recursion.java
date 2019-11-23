public class Recursion {
    public static void main(String[] args) {
        // System.out.println(doubleDigits(5340909, 0));
        // System.out.println(groupChars("mainly"));
        // System.out.println(isSorted(121));
        // System.out.println(largestDigit(-813924311));
        System.out.println(weave(23, 12345));
    }

    public static int doubleDigits(int n, int d) {
        if (d < 0 || d > 9) {
            throw new IllegalArgumentException();
        }
        if (n < 0) {
            return -doubleDigits(-n, d);
        } else if (n == 0) {
            return 0;
        } else if (n % 10 == d) {
            return doubleDigits(n / 10, d) * 100 + d * 10 + d;
        } else {
            return doubleDigits(n / 10, d) * 10 + n % 10;
        }
    }

    public static String groupChars(String s) {
        if (s.isEmpty()) {
            return "*";
        } else if (s.length() == 1 || s.length() == 2) {
            return "[" + s + "]";
        } else {
            return "(" + s.charAt(0) + groupChars(s.substring(1, s.length() - 1)) + s.charAt(s.length() - 1) + ")";
        }
    }

    public static boolean isSorted(int n) {
        if (n < 0) {
            return isSorted(-n);
        } else if (n < 10) {
            return true;
        } else if (n % 10 < n / 10 % 10) {
            return false;
        } else {
            return isSorted(n / 10);
        }
    }

    public static int largestDigit(int n) {
        if (n < 0) {
            return largestDigit(-n);
        } else if (n < 10) {
            return n;
        } else {
            return Math.max(n % 10, largestDigit(n / 10));
        }
    }

    public static String mirrorString(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        } else {
            char front = s.charAt(0);
            return front + mirrorString(s.substring(1)) + front;
        }
    }

    public static boolean sameDashed(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            throw new IllegalArgumentException();
        }
        if (s1.length() == 0) {
            return true;
        } else {
            char char1 = s1.charAt(0);
            char char2 = s2.charAt(0);
            if ((char1 == '-' && char2 != '-') || (char1 != '-' && char2 == '-')) {
                return false;
            } else {
                return sameDashed(s1.substring(1), s2.substring(1));
            }
        }
    }

    public static int nthFromEnd(int num, int n) {
        if (num < 0 || n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return num % 10;
        } else {
            return nthFromEnd(num / 10, n - 1);
        }
    }

    public static void parenthesize(int n) {
        if (n <= 1) {
            System.out.print(n);
        } else if (n % 2 == 0) {
            System.out.print("(" + n + " + ");
            parenthesize(n - 1);
            System.out.print(")");
        } else {
            System.out.print("(");
            parenthesize(n - 1);
            System.out.print(" + " + n + ")");
        }
    }

    public static String pattern(int dot, int bracket) {
        if (dot == 0 && bracket == 0) {
            return "";
        } else if (bracket == 0) { // dot != 0, bracket == 0
            return "." + pattern(dot - 1, 0);
        } else {
            return "[" + pattern(dot, bracket - 1) + "]";
        }
    }

    public static void printDashed(int n) {
        if (n < 0) {
            System.out.print("-");
            printDashed(-n);
        } else if (n < 10) {
            System.out.print(n);
        } else {
            printDashed(n / 10);
            System.out.print("-" + n % 10);
        }
    }

    public static void printSequence(int n) {
        if (n == 1) {
            System.out.print("*");
        } else if (n == 2) {
            System.out.print("**");
        } else if ((n + 1) / 2 % 2 == 0) {
            System.out.print("<");
            printSequence(n - 2);
            System.out.print(">");
        } else {
            System.out.print(">");
            printSequence(n - 2);
            System.out.print("<");
        }
    }

    public static int remove(int n, int d) {
        if (d < 0) {
            throw new IllegalArgumentException();
        }
        if (n < 0) {
            return -remove(-n, d);
        } else if (n == 0) {
            return 0;
        } else if (n % 10 == d) {
            return remove(n / 10, d);
        } else {
            return remove(n / 10, d) * 10 + n % 10;
        }
    }

    public static String repeat(String str, int n) {
        if (n == 1) {
            return str;
        } else if (n % 2 == 0) {
            return repeat(str + str, n / 2);
        } else {
            return str + repeat(str, n - 1);
        }
    }

    public static String replace(String str, char target, char newChar) {
        if (str.length() == 0) {
            return "";
        } else if (str.charAt(0) == target) {
            return newChar + replace(str.substring(1), target, newChar);
        } else {
            return str.charAt(0) + replace(str.substring(1), target, newChar);
        }
    }

    public static void showSplit(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n <= 1) {
            System.out.print(n);
        } else {
            System.out.print(n + " = (");
            if (n % 2 == 0) {
                showSplit(n / 2);
            } else {
                showSplit(n / 2 + 1);
            }
            System.out.print(", ");
            showSplit(n / 2);
            System.out.print(")");
        }
    }

    public static int times(int a, int b) {
        if (a < 0 && b > 0) {
            return -times(-a, b);
        } else if (a > 0 && b < 0) {
            return -times(a, -b);
        } else if (a < 0 && b < 0) {
            return times(-a, -b);
        } else if (a == 0) {
            return 0;
        } else {
            return b + times(a - 1, b);
        }
    }

    public static String vowelsToEnd(String s) {
        if (s.length() == 0) {
            return s;
        } else {
            String vowels = "aeiou";
            if (vowels.contains(s.substring(0, 1))) {
                return vowelsToEnd(s.substring(1)) + s.charAt(0);
            } else {
                return s.charAt(0) + vowelsToEnd(s.substring(1));
            }
        }
    }

    public static int weave(int n1, int n2) {
        if (n1 < 0 || n2 < 0) {
            throw new IllegalArgumentException();
        }
        if (n1 == 0 && n2 == 0) {
            return 0;
        } else {
            return weave(n1 / 10, n2 / 10) * 100 + n1 % 10 * 10 + n2 % 10;
        }
    }
}
