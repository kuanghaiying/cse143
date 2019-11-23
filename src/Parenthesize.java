public class Parenthesize {
    public static void main(String[] args) {
        parenthesize("Tyler", 5);
    }

    public static void parenthesize(String str, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            System.out.print(str);
        } else {
            System.out.print("(");
            parenthesize(str, n - 1);
            System.out.print(")");
        }
    }
}
