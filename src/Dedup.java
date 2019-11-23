public class Dedup {
    public static void main(String[] args) {
        System.out.println(dedup("oodeeeggardd"));
    }

    public static String dedup(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            if (str.charAt(0) == str.charAt(1)) {
                return dedup(str.substring(1));
            } else {
                return str.charAt(0) + dedup(str.substring(1));
            }
        }
    }
}
