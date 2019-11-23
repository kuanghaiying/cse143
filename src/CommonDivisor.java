public class CommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(132, 20));
    }

    public static int gcd(int x, int y) {
        if (x < 0 || y < 0) {
            return gcd(Math.abs(x), Math.abs(y));
        } else if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}
