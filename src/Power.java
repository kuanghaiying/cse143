public class Power {
    public static void main(String[] args) {
        System.out.println(pow(2,16));
    }

    // pre: y >= 0
    // post: return the value of x to the power of y
    public static int pow(int x, int y) {
        if (y < 0) {
            throw new IllegalArgumentException("negative exponent: " + y);
        } else if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            return pow(x * x, y / 2);
        } else {
            return x * pow(x, y - 1); // leap of faith
        }
    }
}
