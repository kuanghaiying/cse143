public class Undouble {
    public static void main(String[] args) {
        System.out.println(undouble("cheese"));
    }

    public static String undouble(String str) {
        if (str.length() <= 1) {
            return str;
        } else {
            if (str.charAt(0) != str.charAt(1)) {
                return str.charAt(0) + undouble(str.substring(1));
            } else {
                return undouble(str.substring(1));
            }
        }
    }
}
