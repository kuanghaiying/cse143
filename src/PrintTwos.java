public class PrintTwos {
    public static void main(String[] args) {
        printTwos(80);
    }

    public static void printTwos(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n % 2 != 0) {
            System.out.print(n);
        } else if (n % 4 != 0) {
            System.out.print("2 * ");
            printTwos(n / 2);
        } else {
            System.out.print("2 * ");
            printTwos(n / 4);
            System.out.print(" * 2");
        }
    }
}
