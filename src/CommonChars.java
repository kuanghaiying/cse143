public class CommonChars {
    public static void main(String[] args) {
        String str1 = "hello world";
        String str2 = "heyya world";
        String result = commonChars(str1, str2);
        System.out.println("str1:   " + str1);
        System.out.println("str2:   " + str2);
        System.out.println("result: " + result);
    }

    public static String commonChars(String str1, String str2) {
        if (str1.length() > 0) {
            if (str1.charAt(0) != str2.charAt(0)) {
                return "." + commonChars(str1.substring(1), str2.substring(1));
            } else {
                return str1.charAt(0) + commonChars(str1.substring(1), str2.substring(1));
            }
        } else {
            return "";
        }
    }
}
