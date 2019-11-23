public class Evens {
    public static void main(String[] args) {
        int even = evens$(-221234333);
        System.out.println(even);
    }

    public static int evens(int num) {
        if (num == 0) {
            return 0;
        } else {
            if (num % 10 % 2 == 0) {
                return num % 10 + evens(num / 10) * 10;
            } else {
                return evens(num / 10);
            }
        }
    }

    public static int evens$(int num) {
        if (num == 0) {
            return 0;
        } else if (num % 2 == 0) {
            return evens$(num / 10) * 10 + num % 10;
        } else {
            return evens$(num / 10);
        }
    }
}
