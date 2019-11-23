public class StarsRecursion {
    public static void main(String[] args) {
        writeStars(9);
        badWriteStar(5);
    }

    public static void writeStars(int n) {
        if (n == 0) {
            System.out.println();
        } else {
            System.out.print("* ");
            writeStars(n - 1);
        }
    }

    public static void badWriteStar(int n) {
        System.out.print("*");
        badWriteStar(n - 1);
    }
}
