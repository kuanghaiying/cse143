public class PrintPattern {
    public static void main(String[] args) {
        for (int i = 0; i <= 7; i++) {
            printPattern(i);
            System.out.println();
        }
    }

    public static void printPattern(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            System.out.print("");
        } else if (n == 1) {
            System.out.print(".");
        } else {
            if (n / 2 % 2 == 0) {
                System.out.print("[");
                printPattern(n - 2);
                System.out.print("]");
            } else {
                System.out.print("(");
                printPattern(n - 2);
                System.out.print(")");
            }
        }
    }
}
