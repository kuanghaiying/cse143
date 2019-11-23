import java.util.*;

public class Expunge {
    public static void main(String[] args) {
        int[] num = {4, 20, 15, 15, 8, 5, 7, 12, 3, 10, 5, 0};
        Stack<Integer> stack = new Stack<>();
        for (int value : num) {
            stack.push(value);
        }
        System.out.println(stack);
        expunge(stack);
        System.out.println(stack);
    }

    public static void expunge(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (!temp.isEmpty() && top >= temp.peek()) {
                temp.push(top);
            } else if (temp.isEmpty()) {
                temp.push(top);
            }
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}
