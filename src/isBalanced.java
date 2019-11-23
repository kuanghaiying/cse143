import java.util.*;

public class isBalanced {
    public static void main(String[] args) {
        System.out.println(isBalanced("(this) is [balanced (properly)], isn’t it?"));
    }

    public static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '(' || curr == ')' || curr == '[' || curr == ']') {
                if (!s.isEmpty()) {
                    if (curr == ')' && s.peek() == '(') {
                        s.pop();
                    } else if (curr == ']' && s.peek() == '[') {
                        s.pop();
                    } else {
                        s.push(curr);
                    }
                } else {
                    s.push(curr);
                }
            }
            System.out.println(s);
        }
        return s.isEmpty();
    }
}
