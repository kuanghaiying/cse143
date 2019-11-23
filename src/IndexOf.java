public class IndexOf {
    public static void main(String[] args) {
        System.out.println(indexOf("aabarack", "Bar"));
    }

    public static int indexOf(String str1, String str2) {
        if (str1.length() >= str2.length() &&
            str1.substring(0, str2.length()).equals(str2)) {
            return 0;
        }
        if (str1.length() <= str2.length() && (!str1.equals(str2))) {
            return -1;
        }
        int index = indexOf(str1.substring(1), str2);
        if (index == -1) {
            return -1;
        }
        return 1 + index;
    }
}
