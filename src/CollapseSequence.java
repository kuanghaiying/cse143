public class CollapseSequence {
    public static void main(String[] args) {
        String result = collapseSequence$("-this----has maaany--dashes---", '-');
        System.out.println("after: " + result);
    }

    public static String collapseSequence(String str, char target) {
        if (str.length() > 1) {
            if (str.charAt(0) == target && str.charAt(1) == target) {
                System.out.println(str.substring(2));
                return str + collapseSequence(str.substring(2), target);
            } else {
                return str + collapseSequence(str.substring(1), target);
            }
        } else {
            return str;
        }
    }

    public static String collapseSequence$(String s, char target) {
        if (s.length() == 1) {
            return s;
        } else if (s.charAt(0) == target && s.charAt(1) == target) {
            return collapseSequence$(s.substring(1), target);
        } else {
            return s.charAt(0) + collapseSequence$(s.substring(1), target);
        }
    }
}
