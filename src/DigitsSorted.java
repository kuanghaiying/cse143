public class DigitsSorted {
    public static void main(String[] args) {
        System.out.println(digitsSorted(24378));
    }

    public static boolean digitsSorted(int n) {
        if (n < 10 && n > -10) {
            return true;
        } else {
            if (n < 0) {
                if ((-n % 10 ) < (-n / 10 % 10)) {
                    return false;
                } else {
                    return digitsSorted(n / 10);
                }
            } else {
                if (n % 10 < n / 10 % 10) {
                    return false;
                } else {
                    return digitsSorted(n / 10);
                }
            }
        }
    }
}
