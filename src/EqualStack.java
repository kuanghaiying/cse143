import java.util.*;

public class EqualStack {
    public static void main(String[] args) {
        int[] list1 = {1, 2, 3, 4, 5};
        int[] list2 = {1, 2, 3, 4, 5};
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 0; i < list1.length; i++) {
            s1.push(list1[i]);
            s2.push(list2[i]);
        }
        System.out.println("equal? " + equals(s1, s2));
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
    }

    public static boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.size() != s2.size()) {
            return false;
        }
        Stack<Integer> s3 = new Stack<Integer>();
        while (!s1.isEmpty()) {
            int num1 = s1.pop();
            int num2 = s2.pop();
            s3.push(num1);
            s3.push(num2);
            if (num1 != num2) {
                while (!s3.isEmpty()) {
                    s2.push(s3.pop());
                    s1.push(s3.pop());
                }
                return false;
            }
        }
        while (!s3.isEmpty()) {
            s2.push(s3.pop());
            s1.push(s3.pop());
        }
        return true;
    }
}
