public class DigitProduct {
    public static void main(String[] args) {
        int num = -3110551;
        System.out.println("digit product of " + num + " = " + digitProduct(num));
    }

    public static int digitProduct(int num) {
        if (num < 10 && num >= 0) {
            System.out.println(num);
            return num;
        } else if (num <= 0 && num > -10) {
            System.out.println(num);
            return num;
        } else {
            if (num % 10 == 0) {
                System.out.print("1 * ");
                return digitProduct(num / 10);
            } else {
                System.out.print(num % 10 + " * ");
                return Math.abs(num % 10) * digitProduct(num / 10);
            }
        }
    }
}
