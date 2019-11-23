public class DigitMatch {
    public static void main(String[] args) {
        System.out.println("match = " + digitMatch(0, 0));
    }

    public static int digitMatch(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {
            throw new IllegalArgumentException();
        }
        if (num1 < 10) {
            if (num2 % 10 == num1) {
                return 1;
            } else {
                return 0;
            }
        } else if (num2 < 10) {
            if (num1 % 10 == num2) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (num1 % 10 == num2 % 10) {
                return 1 + digitMatch(num1 / 10, num2 / 10);
            } else {
                return digitMatch(num1 / 10, num2 / 10);
            }
        }
    }
}
