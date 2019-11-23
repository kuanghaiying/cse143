public class WriteChars {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            writeChars(i);
            System.out.println();
        }
    }

    public static void writeChars(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
        } else {
            System.out.print("<");
            writeChars(n - 2);
            System.out.print(">");
        }
    }
}
