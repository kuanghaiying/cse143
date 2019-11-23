import java.util.*;

public class RepeatRecursion {
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 14, 9};
        Stack<Integer> s = new Stack<>();
        for (int value : arr) {
            s.push(value);
        }
        System.out.println("before: " + s);
        repeat(s);
        System.out.println("after: " + s);
    }

    public static void repeat(Stack<Integer> s) {
        if (s.size() > 0) {
            int top = s.pop();
            repeat(s);
            s.push(top);
            s.push(top);
        }
    }
}
