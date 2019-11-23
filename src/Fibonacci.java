public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(22));
    }

    public static int fibonacci(int n) {
        System.out.println(n);
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
