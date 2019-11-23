public class PrintRange {
    public static void main(String[] args) {
        printRange(1, 12);
    }

    public static void printRange(int x, int y) {
        if (x == y) {
            System.out.print(x);
        } else if (x == y - 1) {
            System.out.print(x + " - " + y);
        } else {
            System.out.print(x + " > ");
            printRange(x + 1, y - 1);
            System.out.print(" < " + y);
        }
    }
}
