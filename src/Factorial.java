public class Factorial {
    public static void main(String[] args) {
        int n = factorialOf(10);
        System.out.println(n);
    }

    public static int factorialOf(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorialOf(n - 1);
        }
    }
}
